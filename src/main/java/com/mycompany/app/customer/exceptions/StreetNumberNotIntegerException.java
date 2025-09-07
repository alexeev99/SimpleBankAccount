package com.mycompany.app.customer.exceptions;

/**
 * Thrown when a street number contains non-numeric characters. <br>
 * <br>
 * A valid street number must consist only of digits.
 */
public class StreetNumberNotIntegerException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid street number.
   *
   * @param streetNumber the invalid street number string
   */
  public StreetNumberNotIntegerException(String streetNumber) {
    super(
        String.format(
            "The provided street number: '%s' is not valid! A street number consists only of"
                + " digits.",
            streetNumber));
  }
}
