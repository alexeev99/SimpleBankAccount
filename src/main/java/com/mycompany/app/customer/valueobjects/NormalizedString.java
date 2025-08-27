package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.NormalizedStringEmptyInputException;

public class NormalizedString {

  private final String normalizedString;

  public NormalizedString(String rawString) {
    this.validateStringIsNotEmpty(rawString);
    String input = rawString;
    input = rawString.trim();
    input = input.toLowerCase();
    this.normalizedString = input;
  }

  private void validateStringIsNotEmpty(String rawString)
      throws NormalizedStringEmptyInputException {
    if (rawString.isBlank()) {
      throw new NormalizedStringEmptyInputException();
    }
  }

  @Override
  public String toString() {
    return this.normalizedString;
  }
}
