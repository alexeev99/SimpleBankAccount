package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.PostalCodeInvalidFormatException;

public class PostalCode {

  private final String postalCode;
  private static final String POSTAL_CODE_REGEX = "^\\d{5}$";

  public PostalCode(String postalCode) throws PostalCodeInvalidFormatException {
    this.validatePostalCode(postalCode);
    this.postalCode = postalCode;
  }

  private void validatePostalCode(String postalCode) throws PostalCodeInvalidFormatException {
    if (!postalCode.matches(POSTAL_CODE_REGEX)) {
      throw new PostalCodeInvalidFormatException(postalCode);
    }
  }

  @Override
  public String toString() {
    return this.postalCode;
  }
}
