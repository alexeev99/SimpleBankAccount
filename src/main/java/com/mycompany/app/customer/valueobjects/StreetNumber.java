package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.StreetNumberNotIntegerException;

public class StreetNumber {

  private final String streetNumber;

  public StreetNumber(String streetNumber) {
    this.validateStreetNumber(streetNumber);
    this.streetNumber = streetNumber;
  }

  private void validateStreetNumber(String streetNumber) {
    try {
      Integer.parseInt(streetNumber);
    } catch (NumberFormatException e) {
      throw new StreetNumberNotIntegerException(streetNumber);
    }
  }

  @Override
  public String toString() {
    return this.streetNumber;
  }
}
