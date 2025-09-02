package com.mycompany.app.userconsole.screens.depositscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class SuccessfulDepositScreen {
  private static final String SUCCESSFUL_TEXT =
      """
      Successfully deposit '%.2f' euro into the bank account
      with following bank ID: '%s'
      """;

  private static UserConsoleScreen successfulText = new UserConsoleScreen(SUCCESSFUL_TEXT);

  public static String getSuccessfulText() {
    return SuccessfulDepositScreen.successfulText.toString();
  }

  public static void setSuccessfulTextFormatting(Double positiveAmountEuro, String bankId) {
    String formattedText =
        String.format(SuccessfulDepositScreen.SUCCESSFUL_TEXT, positiveAmountEuro, bankId);
    SuccessfulDepositScreen.successfulText = new UserConsoleScreen(formattedText);
  }
}
