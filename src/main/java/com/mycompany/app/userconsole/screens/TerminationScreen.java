package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class TerminationScreen {
  private static final String TERMINATION_TEXT =
      """
      Received termination command 'c'.

      Application will be closed.
      """;

  private static final UserConsoleScreen terminationScreen =
      new UserConsoleScreen(TERMINATION_TEXT);

  public static String getText() {
    return TerminationScreen.terminationScreen.toString();
  }
}
