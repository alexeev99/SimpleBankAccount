package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the user console screen that is displayed when the user terminates the application.
 * <br>
 * <br>
 * This screen confirms that the termination command ('c') was received and informs the user that
 * the application will now close.
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * System.out.print(TerminationScreen.getText());
 * System.exit(0);
 * }</pre>
 */
public class TerminationScreen {

  private static final String TERMINATION_TEXT =
      """
      Received termination command 'c'.

      Application will be closed.
      """;

  private static final UserConsoleScreen terminationScreen =
      new UserConsoleScreen(TERMINATION_TEXT);

  /**
   * Returns the termination message text that confirms the user's intention to close the
   * application.
   *
   * @return the termination message as a string
   */
  public static String getText() {
    return TerminationScreen.terminationScreen.toString();
  }
}
