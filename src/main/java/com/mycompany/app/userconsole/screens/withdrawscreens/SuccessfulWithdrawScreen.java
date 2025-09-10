package com.mycompany.app.userconsole.screens.withdrawscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Provides a console screen message for a successful withdrawal operation. <br>
 * <br>
 * This class is responsible for formatting and displaying information about a completed withdrawal,
 * including the withdrawn amount, the associated bank account ID, and the updated account balance.
 *
 * <p>The default message is defined as a template and can be dynamically updated by calling {@link
 * #setSuccessfulTextFormatting(Double, Double, String)}.
 */
public class SuccessfulWithdrawScreen {

  /**
   * Template string for the success message. <br>
   *
   * <ul>
   *   <li>First placeholder: withdrawn amount (formatted to two decimal places)
   *   <li>Second placeholder: bank account ID
   *   <li>Third placeholder: new account balance (formatted to two decimal places)
   * </ul>
   */
  private static final String SUCCESSFUL_TEXT =
      """
      Successfully withdrawn '%.2f' euro from the bank account
      with following bank ID: '%s.'
      New balance is: '%.2f'.
      """;

  /** Holds the formatted success message wrapped in a {@link UserConsoleScreen}. */
  private static UserConsoleScreen successfulText = new UserConsoleScreen(SUCCESSFUL_TEXT);

  /**
   * Returns the currently stored success message. <br>
   * By default, this returns the unformatted template text until it has been updated via {@link
   * #setSuccessfulTextFormatting(Double, Double, String)}.
   *
   * @return the success message as a {@code String}
   */
  public static String getSuccessfulText() {
    return SuccessfulWithdrawScreen.successfulText.toString();
  }

  /**
   * Updates the success message with the provided withdrawal details. <br>
   * The message is formatted using the {@link #SUCCESSFUL_TEXT} template.
   *
   * @param withdrawnAmountEuro the amount withdrawn, in euros
   * @param newAmountEuro the updated balance after withdrawal, in euros
   * @param bankId the identifier of the bank account
   */
  public static void setSuccessfulTextFormatting(
      Double withdrawnAmountEuro, Double newAmountEuro, String bankId) {
    String formattedText =
        String.format(
            SuccessfulWithdrawScreen.SUCCESSFUL_TEXT, withdrawnAmountEuro, bankId, newAmountEuro);
    SuccessfulWithdrawScreen.successfulText = new UserConsoleScreen(formattedText);
  }
}
