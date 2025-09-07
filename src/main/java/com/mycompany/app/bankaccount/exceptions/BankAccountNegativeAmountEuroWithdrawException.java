package com.mycompany.app.bankaccount.exceptions;

/** Thrown when an attempt is made to withdraw a negative amount from a bank account. */
public class BankAccountNegativeAmountEuroWithdrawException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid withdrawal amount.
   *
   * @param amountEuro the negative amount attempted to be withdrawn
   */
  public BankAccountNegativeAmountEuroWithdrawException(double amountEuro) {
    super(String.format("A negative amount %.2f cannot be withdrawn.", amountEuro));
  }
}
