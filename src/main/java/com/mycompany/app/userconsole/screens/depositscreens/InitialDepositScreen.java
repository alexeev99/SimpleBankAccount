package com.mycompany.app.userconsole.screens.depositscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the console screen that guides the user through the initial steps of the deposit
 * process. <br>
 * <br>
 * This screen displays a welcome message and provides textual prompts for entering the necessary
 * customer information required to perform a deposit, such as the bank ID and the deposit amount.
 *
 * <p>The text prompts are wrapped in {@link UserConsoleScreen} instances to allow for potential
 * future formatting or styling. Each input field has its own accessor method that returns the
 * corresponding string prompt for use when requesting input from the user.
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * System.out.print(InitialDepositScreen.getWelcomeText());
 * System.out.print(InitialDepositScreen.getBankIdText());
 * String bankId = scanner.nextLine();
 * }</pre>
 */
public class InitialDepositScreen {

  private static final String WELCOME_TEXT =
      """
      Welcome to the deposit process!

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
   * Returns the welcome message shown at the beginning of the deposit process.
   *
   * @return the welcome message as a string
   */
  public static String getWelcomeText() {
    return InitialDepositScreen.welcomeText.toString();
  }

  /**
   * Returns the prompt text for entering the bank ID.
   *
   * @return the prompt asking the user to enter the bank account ID
   */
  public static String getBankIdText() {
    return InitialDepositScreen.bankIdInput.toString();
  }

  /**
   * Returns the prompt text for entering the monetary amount in euros.
   *
   * @return the prompt asking the user to enter the deposit amount in euros
   */
  public static String getMonetaryAmountEurText() {
    return InitialDepositScreen.monetaryAmountEurInput.toString();
  }
}
