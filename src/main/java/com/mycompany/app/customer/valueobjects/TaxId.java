package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.TaxIdInvalidFormatException;

/**
 * Represents a tax identification number. <br>
 * <br>
 * A {@code TaxId} must consist of exactly 11 digits.
 */
public class TaxId {

  private final String taxId;
  private static final String TAX_ID_REGEX = "^\\d{11}$";

  /**
   * Creates a new {@code TaxId} from the given string.
   *
   * @param taxId the tax ID string
   * @throws TaxIdInvalidFormatException if the tax ID does not match the expected format
   */
  public TaxId(String taxId) throws TaxIdInvalidFormatException {
    this.validateTaxId(taxId);
    this.taxId = taxId;
  }

  private void validateTaxId(String taxId) throws TaxIdInvalidFormatException {
    if (!taxId.matches(TAX_ID_REGEX)) {
      throw new TaxIdInvalidFormatException(taxId);
    }
  }

  /**
   * Returns the string representation of the tax ID.
   *
   * @return the tax ID as a string
   */
  @Override
  public String toString() {
    return this.taxId;
  }
}
