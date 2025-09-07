package com.mycompany.app.userconsole.screens.creationscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the console screen that is shown after a bank account has been successfully created.
 * <br>
 * <br>
 * This screen displays a formatted confirmation message including the customer's first and last
 * name as well as the newly assigned bank ID. The screen content can be customized by formatting
 * the predefined success template with actual customer and bank data.
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * SuccessfulCreationScreen.setSuccessfulTextFormatting("Alice", "Smith", "123-456-789");
 * System.out.print(SuccessfulCreationScreen.getSuccessfulText());
 * }</pre>
 */
public class SuccessfulCreationScreen {

  private static final String SUCCESSFUL_TEXT =
      """
      Successfully created a new Customer: '%s %s'
      with bank ID: '%s'
      """;

  private static UserConsoleScreen successfulText = new UserConsoleScreen(SUCCESSFUL_TEXT);

  /**
   * Formats the success message using the provided customer details and updates the screen
   * representation accordingly.
   *
   * @param firstName the first name of the created customer
   * @param lastName the last name of the created customer
   * @param bankId the unique bank account identifier assigned to the customer
   */
  public static void setSuccessfulTextFormatting(String firstName, String lastName, String bankId) {
    String formattedText =
        String.format(SuccessfulCreationScreen.SUCCESSFUL_TEXT, firstName, lastName, bankId);
    SuccessfulCreationScreen.successfulText = new UserConsoleScreen(formattedText);
  }

  /**
   * Returns the currently formatted success message as plain text.
   *
   * @return the formatted success message string
   */
  public static String getSuccessfulText() {
    return SuccessfulCreationScreen.successfulText.toString();
  }
}
