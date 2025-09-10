package com.mycompany.app.userconsole.screens.withdrawscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class SuccessfulWithdrawScreen {

  private static final String SUCCESSFUL_TEXT =
      """
      Successfully withdrawn '%.2f' euro from the bank account
      with following bank ID: '%s.'
      New balance is: '%.2f'.
      """;

  private static UserConsoleScreen successfulText = new UserConsoleScreen(SUCCESSFUL_TEXT);

  public static String getSuccessfulText() {
    return SuccessfulWithdrawScreen.successfulText.toString();
  }

  public static void setSuccessfulTextFormatting(
      Double withdrawnAmountEuro, Double newAmountEuro, String bankId) {
    String formattedText =
        String.format(
            SuccessfulWithdrawScreen.SUCCESSFUL_TEXT, withdrawnAmountEuro, bankId, newAmountEuro);
    SuccessfulWithdrawScreen.successfulText = new UserConsoleScreen(formattedText);
  }
}
