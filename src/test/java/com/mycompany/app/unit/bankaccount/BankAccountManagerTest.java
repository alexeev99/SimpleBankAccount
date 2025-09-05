package com.mycompany.app.unit.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.bankaccount.BankAccountManager;
import com.mycompany.app.bankaccount.SavingAccount;
import com.mycompany.app.bankaccount.exceptions.BankAccountManagerCouldNotFindAccountException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BankAccountManagerTest {

  @Test
  void shouldFetchAlwaysTheSameInstance() {
    BankAccountManager bankAccountManager1 = BankAccountManager.getInstance();
    BankAccountManager bankAccountManager2 = BankAccountManager.getInstance();

    assertEquals(bankAccountManager1, bankAccountManager2);
  }

  @Test
  void shouldCreateNewBankAccount() {
    BankAccountManager bankAccountManager = BankAccountManager.getInstance();

    BankId bankId = new BankId();
    String bankIdString1 = bankId.toString();

    SavingAccount savingAccount = bankAccountManager.create(bankId);
    String bankIdString2 = savingAccount.getBankId().toString();

    assertEquals(bankIdString1, bankIdString2);
  }

  @Test
  void shouldFindBankAccount() {
    BankAccountManager bankAccountManager = BankAccountManager.getInstance();

    BankId bankId = new BankId();
    String bankIdString1 = bankId.toString();

    bankAccountManager.create(bankId);

    SavingAccount savingAccount = bankAccountManager.find(bankId);
    String bankIdString2 = savingAccount.getBankId().toString();

    assertEquals(bankIdString1, bankIdString2);
  }

  @Test
  void shouldThrowExceptionWhenCannotFindBankAccount() {
    BankAccountManager bankAccountManager = BankAccountManager.getInstance();

    BankId bankId = new BankId();
    String bankIdString1 = bankId.toString();
    String errorMessage =
        String.format("A bank account with the bank ID: '%s' could not be found.", bankIdString1);

    Executable findBankAccountExecutable = () -> bankAccountManager.find(bankId);

    BankAccountManagerCouldNotFindAccountException exception =
        assertThrows(
            BankAccountManagerCouldNotFindAccountException.class, findBankAccountExecutable);

    assertEquals(errorMessage, exception.getMessage());
  }

  @Test
  void shouldDepositIntoBankAccount() {
    BankAccountManager bankAccountManager = BankAccountManager.getInstance();
    Double positiveAmountEuroDouble = 10.0;

    BankId bankId = new BankId();
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroDouble);

    SavingAccount bankAccount = bankAccountManager.create(bankId);
    bankAccountManager.deposit(bankId, positiveAmountEuro);

    assertEquals(bankAccount.balance().toDouble(), positiveAmountEuroDouble);
  }
}
