package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the user console screen that is shown when the user selects an invalid or unsupported
 * operation from the main menu. <br>
 * <br>
 * This screen informs the user that the input was invalid and prompts them to try again. It is
 * typically displayed after reading input from the {@link InitialScreen}.
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * System.out.print(InvalidOperationScreen.getText());
 * }</pre>
 */
public class InvalidOperationScreen {

  private static final String INVALID_OPERATION_TEXT =
      """
      You have chosen an invalid operation!

      Please try again.
      """;

  private static final UserConsoleScreen invalidOperationScreen =
      new UserConsoleScreen(INVALID_OPERATION_TEXT);

  /**
   * Returns the text of the invalid operation screen.
   *
   * @return the invalid operation message as a string
   */
  public static String getText() {
    return InvalidOperationScreen.invalidOperationScreen.toString();
  }
}
