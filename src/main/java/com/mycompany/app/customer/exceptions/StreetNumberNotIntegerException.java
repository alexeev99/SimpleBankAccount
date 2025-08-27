package com.mycompany.app.customer.exceptions;

public class StreetNumberNotIntegerException extends RuntimeException {

  public StreetNumberNotIntegerException(String streetNumber) {
    super(
        String.format(
            "The provided street number: '%s' is not valid! ",
            "A street number consists only of digits.", streetNumber));
  }
}
