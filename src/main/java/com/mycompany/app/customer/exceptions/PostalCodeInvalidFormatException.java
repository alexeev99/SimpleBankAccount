package com.mycompany.app.customer.exceptions;

/**
 * Thrown when a postal code does not conform to the expected format. <br>
 * <br>
 * A valid postal code must consist of exactly 5 digits.
 */
public class PostalCodeInvalidFormatException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid postal code.
   *
   * @param postalCode the invalid postal code string
   */
  public PostalCodeInvalidFormatException(String postalCode) {
    super(
        String.format(
            "The provided postal code: '%s' does not conform to the needed standard. "
                + "A postal code consists of 5 digits.",
            postalCode));
  }
}
