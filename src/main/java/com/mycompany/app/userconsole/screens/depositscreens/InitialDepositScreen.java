package com.mycompany.app.userconsole.screens.depositscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

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

  private static String getWelcomeText() {
    return InitialDepositScreen.welcomeText.toString();
  }

  private static String getBankIdText() {
    return InitialDepositScreen.bankIdInput.toString();
  }

  private static String getMonetaryAmountEurText() {
    return InitialDepositScreen.monetaryAmountEurInput.toString();
  }
}
