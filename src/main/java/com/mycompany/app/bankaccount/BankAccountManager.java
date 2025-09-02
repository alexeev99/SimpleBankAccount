package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountManagerCouldNotFindAccountException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import java.util.HashMap;
import java.util.Map;

public class BankAccountManager {

  private Map<BankId, SavingAccount> bankAccounts = new HashMap<>();

  public SavingAccount create(BankId bankId, PositiveAmountEuro amountEuro) {
    SavingAccount bankAccount = new SavingAccount(bankId, amountEuro);
    this.bankAccounts.put(bankId, bankAccount);
    return bankAccount;
  }

  public SavingAccount find(BankId bankId) throws BankAccountManagerCouldNotFindAccountException {
    SavingAccount bankAccount = this.bankAccounts.get(bankId);
    if (bankAccount == null) {
      throw new BankAccountManagerCouldNotFindAccountException(bankId.toString());
    }
    return bankAccount;
  }

  public void deposit(BankId bankId, PositiveAmountEuro amountEuro)
      throws BankAccountManagerCouldNotFindAccountException {
    SavingAccount bankAccount = this.find(bankId);
    bankAccount.deposit(amountEuro);
  }
}
