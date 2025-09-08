package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.PostalCodeInvalidFormatException;

/**
 * Represents a postal code. <br>
 * <br>
 * A {@code PostalCode} must conform to the format of exactly 5 digits.
 */
public class PostalCode {

  private final String postalCode;
  private static final String POSTAL_CODE_REGEX = "^\\d{5}$";

  /**
   * Creates a new {@code PostalCode} from the given string.
   *
   * @param postalCode the postal code string
   * @throws PostalCodeInvalidFormatException if the postal code does not match the expected format
   */
  public PostalCode(String postalCode) throws PostalCodeInvalidFormatException {
    this.validatePostalCode(postalCode);
    this.postalCode = postalCode;
  }

  private void validatePostalCode(String postalCode) throws PostalCodeInvalidFormatException {
    if (!postalCode.matches(POSTAL_CODE_REGEX)) {
      throw new PostalCodeInvalidFormatException(postalCode);
    }
  }

  /**
   * Returns the string representation of the postal code.
   *
   * @return the postal code as a string
   */
  @Override
  public String toString() {
    return this.postalCode;
  }
}
