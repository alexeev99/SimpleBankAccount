package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class InvalidOperationScreen {

  private static final String INVALID_OPERATION_TEXT =
      """
      You have chosen an invalid operation!

      Please try again.
      """;

  private static final UserConsoleScreen invalidOperationScreen =
      new UserConsoleScreen(INVALID_OPERATION_TEXT);

  public static String getText() {
    return InvalidOperationScreen.invalidOperationScreen.toString();
  }
}
