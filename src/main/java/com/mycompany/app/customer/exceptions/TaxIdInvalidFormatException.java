package com.mycompany.app.customer.exceptions;

/**
 * Thrown when a tax ID does not conform to the expected format. <br>
 * <br>
 * A valid tax ID must consist of exactly 11 digits.
 */
public class TaxIdInvalidFormatException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid tax ID.
   *
   * @param taxId the invalid tax ID string
   */
  public TaxIdInvalidFormatException(String taxId) {
    super(
        String.format(
            "The provided tax ID: '%s' does not conform to the needed standard. "
                + "A tax ID consists of 11 digits.",
            taxId));
  }
}
