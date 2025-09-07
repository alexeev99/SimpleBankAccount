package com.mycompany.app.userconsole;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a single line of text on the user console. <br>
 * <br>
 * A {@code UserConsoleLine} splits the given text into individual words and stores each one as a
 * {@link UserConsoleString}. Each word is indexed to preserve ordering, allowing the line to be
 * treated as an ordered collection of console strings.
 *
 * <p>The original text is preserved and returned when calling {@link #toString()}.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * String rawLine = "Hello World from Console";
 * UserConsoleLine line = new UserConsoleLine(rawLine);
 * System.out.println(line.toString()); // prints: Hello World from Console
 * }</pre>
 */
public class UserConsoleLine {

  private final Map<Integer, UserConsoleString> indexWordMap = new HashMap<>();
  private Integer countWords = 0;
  private String text;

  /**
   * Constructs a new {@code UserConsoleLine} instance from the provided text.
   *
   * <p>The text is split into words by spaces, and each word is wrapped as a {@link
   * UserConsoleString}.
   *
   * @param text the raw text that defines the content of the line
   */
  public UserConsoleLine(String text) {
    this.constructIndexWordMap(text);
    this.text = text;
  }

  /**
   * Splits the given text into words and populates the internal word map with {@link
   * UserConsoleString} instances.
   *
   * @param text the text to be split into words
   */
  private void constructIndexWordMap(String text) {
    String[] splitText = text.split(" ");
    for (String word : splitText) {
      UserConsoleString consoleString = new UserConsoleString(word);
      this.indexWordMap.put(this.countWords, consoleString);
      this.countWords++;
    }
  }

  /**
   * Returns the original text representation of the console line.
   *
   * @return the raw text of this line
   */
  @Override
  public String toString() {
    return this.text;
  }
}
