package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class InitialScreen {
  private static final String TEXT =
      """
      Welcome to the SimpleBankApp!

      With which operation do you want to proceed ?

      Type in the corresponding number (e.g. 1, 2, 3, ...)
      in order to proceed with your chosen operation.

      1. Create a new Bank Account
      2. Deposit money into a Bank Account

      Type in 'c' to terminate the application.

      Your input: \
      """;
  private static UserConsoleScreen initialScreen = new UserConsoleScreen(TEXT);

  public static String getText() {
    return InitialScreen.initialScreen.toString();
  }
}
