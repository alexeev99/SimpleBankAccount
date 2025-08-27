package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.TaxIdInvalidFormatException;

public class TaxId {

  private final String taxId;
  private static final String TAX_ID_REGEX = "^\\d{11}$";

  public TaxId(String taxId) throws TaxIdInvalidFormatException {
    this.validateTaxId(taxId);
    this.taxId = taxId;
  }

  private void validateTaxId(String taxId) throws TaxIdInvalidFormatException {
    if (!taxId.matches(TAX_ID_REGEX)) {
      throw new TaxIdInvalidFormatException(taxId);
    }
  }

  @Override
  public String toString() {
    return this.taxId;
  }
}
