package com.mycompany.app.customer.exceptions;

public class PostalCodeInvalidFormatException extends RuntimeException {

  public PostalCodeInvalidFormatException(String postalCode) {
    super(
        String.format(
            "The provided postal code: '%s' does not conform to the ",
            "needed standard. A postal code consists of 5 digits.", postalCode));
  }
}
