package com.mycompany.app.userconsole.screens.withdrawscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Provides the console screen messages for the initial withdrawal process. <br>
 * <br>
 * This class defines the static texts that guide the user through entering the necessary
 * information for a withdrawal operation, including:
 *
 * <ul>
 *   <li>A welcome message introducing the withdrawal process
 *   <li>A prompt for entering the bank account ID
 *   <li>A prompt for entering the withdrawal amount in euros
 * </ul>
 *
 * <p>Each message is wrapped in a {@link UserConsoleScreen} object and can be retrieved using
 * dedicated getter methods.
 */
public class InitialWithdrawScreen {

  private static final String WELCOME_TEXT =
      """
      Welcome to the withdraw process!

      Please type in the necessary information
      from the customer:
      """;

  private static final String BANK_ID_INPUT = "Bank ID: ";
  private static final String MONETARY_AMOUNT_EUR_INPUT = "Monetary amount in euro: ";
  private static final UserConsoleScreen welcomeText = new UserConsoleScreen(WELCOME_TEXT);
  private static final UserConsoleScreen bankIdInput = new UserConsoleScreen(BANK_ID_INPUT);
  private static final UserConsoleScreen monetaryAmountEurInput =
      new UserConsoleScreen(MONETARY_AMOUNT_EUR_INPUT);

  /**
   * Returns the welcome message shown at the beginning of the withdrawal process.
   *
   * @return the welcome message as a string
   */
  public static String getWelcomeText() {
    return InitialWithdrawScreen.welcomeText.toString();
  }

  /**
   * Returns the prompt text for entering the bank ID.
   *
   * @return the prompt asking the user to enter the bank account ID
   */
  public static String getBankIdText() {
    return InitialWithdrawScreen.bankIdInput.toString();
  }

  /**
   * Returns the prompt text for entering the monetary amount in euros.
   *
   * @return the prompt asking the user to enter the withdrawal amount in euros
   */
  public static String getMonetaryAmountEurText() {
    return InitialWithdrawScreen.monetaryAmountEurInput.toString();
  }
}
