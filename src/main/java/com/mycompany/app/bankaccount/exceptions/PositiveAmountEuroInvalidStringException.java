package com.mycompany.app.bankaccount.exceptions;

/** Thrown when a given string cannot be parsed into a valid positive monetary amount in euros. */
public class PositiveAmountEuroInvalidStringException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid monetary amount string.
   *
   * @param positiveAmountEuro the invalid monetary amount string
   */
  public PositiveAmountEuroInvalidStringException(String positiveAmountEuro) {
    super(
        String.format(
            "Following given monetary amount: '%s' is invalid and could not be transformed to a"
                + " double.",
            positiveAmountEuro));
  }
}
