package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountManagerCouldNotFindAccountException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton manager responsible for creating, retrieving, and managing bank accounts. <br>
 * <br>
 * This class provides central access to all {@link SavingAccount} instances and enforces the
 * singleton pattern to ensure there is only one manager instance during the application's
 * lifecycle.
 */
public class BankAccountManagerSingleton {

  private static BankAccountManagerSingleton instance;

  /** Internal map of bank accounts, keyed by their {@link BankId} string representation. */
  private Map<String, SavingAccount> bankAccounts = new HashMap<>();

  /** Private constructor to enforce singleton usage. */
  private BankAccountManagerSingleton() {}

  /**
   * Returns the singleton instance of the bank account manager.
   *
   * @return the singleton {@code BankAccountManagerSingleton}
   */
  public static BankAccountManagerSingleton getInstance() {
    if (instance == null) {
      instance = new BankAccountManagerSingleton();
    }
    return instance;
  }

  /**
   * Creates a new saving account with the given bank ID and initial balance.
   *
   * @param bankId the unique bank account ID
   * @param amountEuro the initial balance
   * @return the created {@link SavingAccount}
   */
  public SavingAccount create(BankId bankId, PositiveAmountEuro amountEuro) {
    SavingAccount bankAccount = new SavingAccount(bankId, amountEuro);
    this.bankAccounts.put(bankId.toString(), bankAccount);
    return bankAccount;
  }

  /**
   * Creates a new saving account with the given bank ID and zero initial balance.
   *
   * @param bankId the unique bank account ID
   * @return the created {@link SavingAccount}
   */
  public SavingAccount create(BankId bankId) {
    SavingAccount bankAccount = new SavingAccount(bankId);
    this.bankAccounts.put(bankId.toString(), bankAccount);
    return bankAccount;
  }

  /**
   * Finds an existing bank account by its ID.
   *
   * @param bankId the unique bank account ID
   * @return the {@link SavingAccount} associated with the ID
   * @throws BankAccountManagerCouldNotFindAccountException if the account does not exist
   */
  public SavingAccount find(BankId bankId) throws BankAccountManagerCouldNotFindAccountException {
    String bankIdString = bankId.toString();
    SavingAccount bankAccount = this.bankAccounts.get(bankIdString);
    if (bankAccount == null) {
      throw new BankAccountManagerCouldNotFindAccountException(bankIdString);
    }
    return bankAccount;
  }

  /**
   * Deposits the specified amount into the bank account with the given ID.
   *
   * @param bankId the unique bank account ID
   * @param amountEuro the amount to deposit
   * @throws BankAccountManagerCouldNotFindAccountException if the account does not exist
   */
  public void deposit(BankId bankId, PositiveAmountEuro amountEuro)
      throws BankAccountManagerCouldNotFindAccountException {
    SavingAccount bankAccount = this.find(bankId);
    bankAccount.deposit(amountEuro);
  }
}
