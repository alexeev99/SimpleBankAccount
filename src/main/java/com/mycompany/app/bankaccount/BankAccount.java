package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import com.mycompany.app.bankaccount.valueobjects.Transaction;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an abstract bank account. <br>
 * <br>
 * A {@code BankAccount} defines the common behavior for account types, such as depositing money,
 * withdrawing money, checking balances, and retrieving the associated {@link BankId}.
 *
 * <p>Each account maintains a map of {@link Transaction} objects for tracking account activity, as
 * well as the current balance.
 *
 * <p>This class is abstract and should be extended by concrete account implementations such as
 * {@link SavingAccount}.
 */
public abstract class BankAccount {

  /** Holds the account's transaction history, keyed by transaction ID. */
  protected Map<String, Transaction> transactions = new HashMap<>();

  /** The current account balance in euros. */
  protected PositiveAmountEuro amountEuro = new PositiveAmountEuro(0);

  /** The unique identifier for the account. */
  protected BankId bankId;

  /**
   * Constructs a bank account with an initial balance.
   *
   * @param bankId the unique bank account ID
   * @param amountEuro the initial balance
   */
  protected BankAccount(BankId bankId, PositiveAmountEuro amountEuro) {}

  /**
   * Constructs a bank account with zero initial balance.
   *
   * @param bankId the unique bank account ID
   */
  protected BankAccount(BankId bankId) {}

  /**
   * Withdraws the specified amount from the account.
   *
   * @param amountEuro the amount to withdraw
   * @return the new balance after withdrawal
   * @throws BankAccountNegativeAmountEuroWithdrawException if the withdrawal would make the balance
   *     negative
   */
  public abstract PositiveAmountEuro withdraw(PositiveAmountEuro amountEuro)
      throws BankAccountNegativeAmountEuroWithdrawException;

  /**
   * Deposits the specified amount into the account.
   *
   * @param amountEuro the amount to deposit
   */
  public abstract void deposit(PositiveAmountEuro amountEuro);

  /**
   * Returns the current account balance.
   *
   * @return the balance as a {@link PositiveAmountEuro}
   */
  public abstract PositiveAmountEuro balance();

  /**
   * Returns the unique bank ID of the account.
   *
   * @return the {@link BankId} of the account
   */
  public abstract BankId getBankId();
}
