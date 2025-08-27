package com.mycompany.app.customer.exceptions;

public class TaxIdInvalidFormatException extends RuntimeException {

  public TaxIdInvalidFormatException(String taxId) {
    super(
        String.format(
            "The provided tax ID: '%s' does not conform to the ",
            "needed standard. A tax ID consists of 11 digits.", taxId));
  }
}
