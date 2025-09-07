package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.StreetNumberNotIntegerException;

/**
 * Represents a street number. <br>
 * <br>
 * A {@code StreetNumber} ensures that the value consists only of digits.
 */
public class StreetNumber {

  private final String streetNumber;

  /**
   * Creates a new {@code StreetNumber} from the given string.
   *
   * @param streetNumber the street number string
   * @throws StreetNumberNotIntegerException if the string cannot be parsed as an integer
   */
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

  /**
   * Returns the string representation of the street number.
   *
   * @return the street number as a string
   */
  @Override
  public String toString() {
    return this.streetNumber;
  }
}
