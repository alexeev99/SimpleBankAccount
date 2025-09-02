package com.mycompany.app.bankaccount.exceptions;

public class PositiveAmountEuroInvalidStringException extends RuntimeException {

  public PositiveAmountEuroInvalidStringException(String positiveAmountEuro) {
    super(
        String.format(
            "Following given monetary amount: '%s' is invalid and could not be transformed to a"
                + " double.",
            positiveAmountEuro));
  }
}
