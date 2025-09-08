package com.mycompany.app.userconsole;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a console screen consisting of one or more lines of text. <br>
 * <br>
 * This class takes raw text input, splits it into lines, and stores each line as a {@link
 * UserConsoleLine}. Each line is indexed internally, allowing the screen to be treated as an
 * ordered collection of console lines.
 *
 * <p>The original text is preserved and returned when calling {@link #toString()}.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * String rawText = "Hello World\nThis is a test screen";
 * UserConsoleScreen screen = new UserConsoleScreen(rawText);
 * System.out.println(screen.toString());
 * }</pre>
 */
public class UserConsoleScreen {

  private final Map<Integer, UserConsoleLine> indexLineMap = new HashMap<>();
  private Integer countLines = 0;
  private String text;

  /**
   * Constructs a new {@code UserConsoleScreen} instance from the provided text.
   *
   * <p>The text is split by line breaks, and each line is stored as a separate {@link
   * UserConsoleLine}.
   *
   * @param text the raw text that defines the content of the screen
   */
  public UserConsoleScreen(String text) {
    this.constructIndexLineMap(text);
    this.text = text;
  }

  /**
   * Splits the given text into lines and populates the internal line map with {@link
   * UserConsoleLine} instances.
   *
   * @param text the text to be split into lines
   */
  private void constructIndexLineMap(String text) {
    String[] splitText = text.split("\n");
    for (String line : splitText) {
      UserConsoleLine consoleLine = new UserConsoleLine(line);
      this.indexLineMap.put(this.countLines, consoleLine);
      this.countLines++;
    }
  }

  /**
   * Returns the original text representation of the screen, including line breaks.
   *
   * @return the raw text of the screen
   */
  @Override
  public String toString() {
    return this.text;
  }
}
