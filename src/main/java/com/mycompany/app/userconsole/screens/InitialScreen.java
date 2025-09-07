package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the initial user console screen of the SimpleBankApp. <br>
 * <br>
 * This screen welcomes the user to the application and presents a menu of available operations. It
 * provides the user with instructions on how to proceed by typing the corresponding number or
 * character for the desired operation.
 *
 * <p>The available options are:
 *
 * <ul>
 *   <li><b>1</b> - Create a new Bank Account
 *   <li><b>2</b> - Deposit money into an existing Bank Account
 *   <li><b>c</b> - Terminate the application
 * </ul>
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * System.out.print(InitialScreen.getText());
 * String userInput = scanner.nextLine();
 * }</pre>
 */
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

  /**
   * Returns the initial screen text including the menu of available operations and instructions for
   * the user.
   *
   * @return the initial screen text as a string
   */
  public static String getText() {
    return InitialScreen.initialScreen.toString();
  }
}
