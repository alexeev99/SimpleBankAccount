package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroNegativeValueException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;

/**
 * Represents a saving account, which is a concrete implementation of {@link BankAccount}. <br>
 * <br>
 * A {@code SavingAccount} enforces positive balances, supports deposits and withdrawals, and
 * provides access to the current balance and its {@link BankId}.
 */
public class SavingAccount extends BankAccount {

  /**
   * Creates a new saving account with the given bank ID and initial balance.
   *
   * @param bankId the unique bank account ID
   * @param amountEuro the initial balance
   */
  public SavingAccount(BankId bankId, PositiveAmountEuro amountEuro) {
    super(bankId, amountEuro);
    this.amountEuro = amountEuro;
    this.bankId = bankId;
  }

  /**
   * Creates a new saving account with the given bank ID and zero initial balance.
   *
   * @param bankId the unique bank account ID
   */
  public SavingAccount(BankId bankId) {
    super(bankId);
    this.bankId = bankId;
  }

  /**
   * Withdraws money from the account while ensuring the balance does not go negative.
   *
   * @param amountEuro the amount to withdraw
   * @return the new balance after withdrawal
   * @throws BankAccountNegativeAmountEuroWithdrawException if the withdrawal would make the balance
   *     negative
   */
  public PositiveAmountEuro withdraw(PositiveAmountEuro amountEuro)
      throws BankAccountNegativeAmountEuroWithdrawException {
    PositiveAmountEuro newAmountEuro;
    try {
      newAmountEuro = this.amountEuro.subtract(amountEuro);
    } catch (PositiveAmountEuroNegativeValueException e) {
      throw new BankAccountNegativeAmountEuroWithdrawException(amountEuro.toDouble());
    }
    this.amountEuro = newAmountEuro;
    return newAmountEuro;
  }

  /**
   * Deposits the specified amount into the account.
   *
   * @param amountEuro the amount to deposit
   */
  public void deposit(PositiveAmountEuro amountEuro) {
    this.amountEuro = this.amountEuro.add(amountEuro);
  }

  /**
   * Returns the current balance of the account.
   *
   * @return the balance as a {@link PositiveAmountEuro}
   */
  public PositiveAmountEuro balance() {
    return this.amountEuro;
  }

  /**
   * Returns the unique bank ID of the account.
   *
   * @return the {@link BankId} of this account
   */
  public BankId getBankId() {
    return this.bankId;
  }
}
