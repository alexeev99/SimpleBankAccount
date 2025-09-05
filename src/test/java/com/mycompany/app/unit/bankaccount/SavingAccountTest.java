package com.mycompany.app.unit.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.bankaccount.SavingAccount;
import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class SavingAccountTest {
  @Test
  void shouldCreateSavingAccountWithBankIdAndAmountEuro() {
    Double amountEuroDouble = 10.0;
    BankId bankId = new BankId();
    PositiveAmountEuro amountEuro = new PositiveAmountEuro(amountEuroDouble);

    SavingAccount savingAccount = new SavingAccount(bankId, amountEuro);

    assertEquals(savingAccount.balance().toDouble(), amountEuroDouble);
    assertEquals(savingAccount.getBankId().toString(), bankId.toString());
  }

  @Test
  void shouldCreateSavingAccountWithBankIdAndWithoutAmountEuro() {
    BankId bankId = new BankId();

    SavingAccount savingAccount = new SavingAccount(bankId);

    assertEquals(savingAccount.balance().toDouble(), 0);
    assertEquals(savingAccount.getBankId().toString(), bankId.toString());
  }

  @Test
  void shouldDepositAmountEuro() {
    Double amountEuroDouble = 10.0;
    BankId bankId = new BankId();
    PositiveAmountEuro amountEuro = new PositiveAmountEuro(amountEuroDouble);
    SavingAccount savingAccount = new SavingAccount(bankId);

    savingAccount.deposit(amountEuro);

    assertEquals(savingAccount.balance().toDouble(), amountEuroDouble);
  }

  @Test
  void shouldWithdrawAmountEuro() {
    Double amountEuroDouble1 = 20.0;
    Double amountEuroDouble2 = 10.0;
    Double resultAmountEuroDouble = amountEuroDouble1 - amountEuroDouble2;
    BankId bankId = new BankId();
    PositiveAmountEuro amountEuro1 = new PositiveAmountEuro(amountEuroDouble1);
    PositiveAmountEuro amountEuro2 = new PositiveAmountEuro(amountEuroDouble2);

    SavingAccount savingAccount = new SavingAccount(bankId, amountEuro1);

    savingAccount.withdraw(amountEuro2);

    assertEquals(savingAccount.balance().toDouble(), resultAmountEuroDouble);
  }

  @Test
  void shouldThrowExceptionWhenWithdrawBelowZero() {
    Double amountEuroDouble1 = 10.0;
    Double amountEuroDouble2 = 20.0;
    String errorMessage =
        String.format("A negative amount %.2f cannot be withdrawn.", amountEuroDouble2);

    BankId bankId = new BankId();
    PositiveAmountEuro amountEuro1 = new PositiveAmountEuro(amountEuroDouble1);
    PositiveAmountEuro amountEuro2 = new PositiveAmountEuro(amountEuroDouble2);

    SavingAccount savingAccount = new SavingAccount(bankId, amountEuro1);

    Executable savingAccountWithdrawExecutable = () -> savingAccount.withdraw(amountEuro2);

    BankAccountNegativeAmountEuroWithdrawException exception =
        assertThrows(
            BankAccountNegativeAmountEuroWithdrawException.class, savingAccountWithdrawExecutable);

    assertEquals(errorMessage, exception.getMessage());
  }
}
