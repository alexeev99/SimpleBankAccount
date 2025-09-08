package com.mycompany.app.unit.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.bankaccount.BankAccountManagerSingleton;
import com.mycompany.app.bankaccount.SavingAccount;
import com.mycompany.app.bankaccount.exceptions.BankAccountManagerCouldNotFindAccountException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BankAccountManagerTest {

  @Test
  void shouldFetchAlwaysTheSameInstance() {
    BankAccountManagerSingleton bankAccountManager1 = BankAccountManagerSingleton.getInstance();
    BankAccountManagerSingleton bankAccountManager2 = BankAccountManagerSingleton.getInstance();

    assertEquals(bankAccountManager1, bankAccountManager2);
  }

  @Test
  void shouldCreateNewBankAccount() {
    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();

    BankId bankId = new BankId();
    String bankIdString1 = bankId.toString();

    SavingAccount savingAccount = bankAccountManager.create(bankId);
    String bankIdString2 = savingAccount.getBankId().toString();

    assertEquals(bankIdString1, bankIdString2);
  }

  @Test
  void shouldFindBankAccount() {
    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();

    BankId bankId = new BankId();
    String bankIdString1 = bankId.toString();

    bankAccountManager.create(bankId);

    SavingAccount savingAccount = bankAccountManager.find(bankId);
    String bankIdString2 = savingAccount.getBankId().toString();

    assertEquals(bankIdString1, bankIdString2);
  }

  @Test
  void shouldThrowExceptionWhenCannotFindBankAccount() {
    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();

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
    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();
    Double positiveAmountEuroDouble = 10.0;

    BankId bankId = new BankId();
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroDouble);

    SavingAccount bankAccount = bankAccountManager.create(bankId);
    bankAccountManager.deposit(bankId, positiveAmountEuro);

    assertEquals(bankAccount.balance().toDouble(), positiveAmountEuroDouble);
  }
}
