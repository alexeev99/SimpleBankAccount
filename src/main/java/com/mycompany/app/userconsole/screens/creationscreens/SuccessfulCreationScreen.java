package com.mycompany.app.userconsole.screens.creationscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class SuccessfulCreationScreen {
  private static final String SUCCESSFUL_TEXT =
      """
      Successfully created a new Customer: '%s %s'
      with bank ID: '%s'
      """;

  private static UserConsoleScreen successfulText = new UserConsoleScreen(SUCCESSFUL_TEXT);

  public static void setSuccessfulTextFormatting(String firstName, String lastName, String bankId) {
    String formattedText =
        String.format(SuccessfulCreationScreen.SUCCESSFUL_TEXT, firstName, lastName, bankId);
    SuccessfulCreationScreen.successfulText = new UserConsoleScreen(formattedText);
  }

  public static String getSuccessfulText() {
    return SuccessfulCreationScreen.successfulText.toString();
  }
}
