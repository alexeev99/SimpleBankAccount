package com.mycompany.app.customer.exceptions;

/**
 * Thrown when a {@code NormalizedString} is created with an empty string or a string consisting
 * only of whitespace characters.
 */
public class NormalizedStringEmptyInputException extends RuntimeException {

  /**
   * Constructs a new exception with a default message indicating that empty or whitespace-only
   * strings are not allowed.
   */
  public NormalizedStringEmptyInputException() {
    super(
        String.format(
            "Providing a string which is either empty or consists only of white spaces is not"
                + " allowed."));
  }
}
