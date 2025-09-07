package com.mycompany.app.userconsole.screens.depositscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the user console screen that is displayed after a successful deposit operation. <br>
 * <br>
 * The screen shows a confirmation message containing the deposited amount and the bank account ID
 * into which the money has been deposited.
 *
 * <p>The message template supports dynamic formatting through {@link
 * #setSuccessfulTextFormatting(Double, String)}, which replaces the placeholders with the actual
 * deposit amount and bank ID.
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * SuccessfulDepositScreen.setSuccessfulTextFormatting(250.00, "BANK-12345");
 * System.out.print(SuccessfulDepositScreen.getSuccessfulText());
 * }</pre>
 */
public class SuccessfulDepositScreen {

  private static final String SUCCESSFUL_TEXT =
      """
      Successfully deposit '%.2f' euro into the bank account
      with following bank ID: '%s'
      """;

  private static UserConsoleScreen successfulText = new UserConsoleScreen(SUCCESSFUL_TEXT);

  /**
   * Returns the currently formatted success message as a string.
   *
   * @return the formatted success message
   */
  public static String getSuccessfulText() {
    return SuccessfulDepositScreen.successfulText.toString();
  }

  /**
   * Formats the success message with the given deposit details and updates the screen
   * representation accordingly.
   *
   * @param positiveAmountEuro the deposited amount in euros; formatted to two decimal places
   * @param bankId the unique bank account identifier into which the deposit was made
   */
  public static void setSuccessfulTextFormatting(Double positiveAmountEuro, String bankId) {
    String formattedText =
        String.format(SuccessfulDepositScreen.SUCCESSFUL_TEXT, positiveAmountEuro, bankId);
    SuccessfulDepositScreen.successfulText = new UserConsoleScreen(formattedText);
  }
}
