package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountManagerCouldNotFindAccountException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import java.util.HashMap;
import java.util.Map;

public class BankAccountManagerSingleton {

  private static BankAccountManagerSingleton instance;

  private BankAccountManagerSingleton() {}

  public static BankAccountManagerSingleton getInstance() {
    if (instance == null) {
      instance = new BankAccountManagerSingleton();
    }
    return instance;
  }

  private Map<String, SavingAccount> bankAccounts = new HashMap<>();

  public SavingAccount create(BankId bankId, PositiveAmountEuro amountEuro) {
    SavingAccount bankAccount = new SavingAccount(bankId, amountEuro);
    this.bankAccounts.put(bankId.toString(), bankAccount);
    return bankAccount;
  }

  public SavingAccount create(BankId bankId) {
    SavingAccount bankAccount = new SavingAccount(bankId);
    this.bankAccounts.put(bankId.toString(), bankAccount);
    return bankAccount;
  }

  public SavingAccount find(BankId bankId) throws BankAccountManagerCouldNotFindAccountException {
    String bankIdString = bankId.toString();
    SavingAccount bankAccount = this.bankAccounts.get(bankIdString);
    if (bankAccount == null) {
      throw new BankAccountManagerCouldNotFindAccountException(bankIdString);
    }
    return bankAccount;
  }

  public void deposit(BankId bankId, PositiveAmountEuro amountEuro)
      throws BankAccountManagerCouldNotFindAccountException {
    SavingAccount bankAccount = this.find(bankId);
    bankAccount.deposit(amountEuro);
  }
}
