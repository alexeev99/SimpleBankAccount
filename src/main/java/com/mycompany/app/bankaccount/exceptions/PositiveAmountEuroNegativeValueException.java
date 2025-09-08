package com.mycompany.app.bankaccount.exceptions;

/** Thrown when a negative monetary amount is provided where only positive amounts are allowed. */
public class PositiveAmountEuroNegativeValueException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid negative amount.
   *
   * @param amountError the negative amount in euros
   */
  public PositiveAmountEuroNegativeValueException(double amountError) {
    super(String.format("The provided balance in Euro: '%.2f' cannot be negative.", amountError));
  }
}
