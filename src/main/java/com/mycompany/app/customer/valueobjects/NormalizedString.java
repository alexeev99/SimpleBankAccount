package com.mycompany.app.customer.valueobjects;

import com.mycompany.app.customer.exceptions.NormalizedStringEmptyInputException;

/**
 * Represents a normalized string value. <br>
 * <br>
 * A {@code NormalizedString} trims leading and trailing whitespace, converts the text to lowercase,
 * and rejects empty or blank inputs.
 *
 * <p>This value object is used for consistently storing and comparing user-provided text fields
 * such as names or city names.
 */
public class NormalizedString {

  private final String normalizedString;

  /**
   * Creates a new {@code NormalizedString} from the given raw string.
   *
   * @param rawString the input string
   * @throws NormalizedStringEmptyInputException if the string is empty or blank
   */
  public NormalizedString(String rawString) {
    this.validateStringIsNotEmpty(rawString);
    String input = rawString.trim().toLowerCase();
    this.normalizedString = input;
  }

  private void validateStringIsNotEmpty(String rawString)
      throws NormalizedStringEmptyInputException {
    if (rawString.isBlank()) {
      throw new NormalizedStringEmptyInputException();
    }
  }

  /**
   * Returns the normalized string value.
   *
   * @return the normalized string
   */
  @Override
  public String toString() {
    return this.normalizedString;
  }
}
