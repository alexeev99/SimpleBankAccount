package com.mycompany.app.userconsole;

/**
 * Represents a single word or token of text on the user console. <br>
 * <br>
 * A {@code UserConsoleString} acts as a simple wrapper around a raw string value. While it
 * currently only stores the plain text, it can be extended in the future to support additional
 * features such as formatting (e.g., colors, bold, italics) or metadata.
 *
 * <p>The original text is preserved and returned when calling {@link #toString()}.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * UserConsoleString word = new UserConsoleString("Hello");
 * System.out.println(word.toString()); // prints: Hello
 * }</pre>
 */
public class UserConsoleString {
  private String text;

  /**
   * Constructs a new {@code UserConsoleString} instance with the given text.
   *
   * @param text the raw string content to wrap
   */
  public UserConsoleString(String text) {
    this.text = text;
  }

  /**
   * Returns the underlying text of this console string.
   *
   * @return the raw text as a string
   */
  @Override
  public String toString() {
    return this.text;
  }
}
