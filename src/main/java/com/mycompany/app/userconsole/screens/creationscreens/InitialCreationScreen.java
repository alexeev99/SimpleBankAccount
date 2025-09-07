package com.mycompany.app.userconsole.screens.creationscreens;

import com.mycompany.app.userconsole.UserConsoleScreen;

/**
 * Represents the console screen that guides the user through the initial steps of the bank account
 * creation process. <br>
 * <br>
 * This screen displays a welcome message and provides a series of textual prompts for entering
 * customer information such as first name, last name, city of birth, birth date, tax ID, and
 * address details.
 *
 * <p>The text prompts are wrapped in {@link UserConsoleScreen} instances to allow for potential
 * future formatting or styling. Each input field has its own accessor method that returns the
 * corresponding string prompt for use when requesting input from the user.
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * System.out.print(InitialCreationScreen.getWelcomeText());
 * System.out.print(InitialCreationScreen.getFirstNameText());
 * String firstName = scanner.nextLine();
 * }</pre>
 */
public class InitialCreationScreen {

  private static final String WELCOME_TEXT =
      """
      Welcome to bank account creation process!

      As the first step, please type in the necessary
      customer information:
      """;

  private static final String FIRST_NAME_INPUT = "First Name: ";
  private static final String LAST_NAME_INPUT = "Last Name: ";
  private static final String CITY_OF_BIRTH_INPUT = "City of birth: ";
  private static final String BIRTH_DATE_INPUT = "Birth date (YYYY-MM-DD): ";
  private static final String TAX_ID_INPUT = "Tax ID: ";
  private static final String ADDRESS_CITY_INPUT = "City of residance: ";
  private static final String ADDRESS_POSTAL_CODE_INPUT = "Postal code: ";
  private static final String ADDRESS_STREET_NAME_INPUT = "Street name: ";
  private static final String ADDRESS_STREET_NUMBER_INPUT = "Street number: ";

  private static UserConsoleScreen welcomeText = new UserConsoleScreen(WELCOME_TEXT);
  private static UserConsoleScreen firstNameInput = new UserConsoleScreen(FIRST_NAME_INPUT);
  private static UserConsoleScreen lastNameInput = new UserConsoleScreen(LAST_NAME_INPUT);
  private static UserConsoleScreen cityOfBirthInput = new UserConsoleScreen(CITY_OF_BIRTH_INPUT);
  private static UserConsoleScreen birthDateInput = new UserConsoleScreen(BIRTH_DATE_INPUT);
  private static UserConsoleScreen taxIdInput = new UserConsoleScreen(TAX_ID_INPUT);
  private static UserConsoleScreen addressCityInput = new UserConsoleScreen(ADDRESS_CITY_INPUT);
  private static UserConsoleScreen addressPostalCodeInput =
      new UserConsoleScreen(ADDRESS_POSTAL_CODE_INPUT);
  private static UserConsoleScreen addressStreetNameInput =
      new UserConsoleScreen(ADDRESS_STREET_NAME_INPUT);
  private static UserConsoleScreen addressStreetNumberInput =
      new UserConsoleScreen(ADDRESS_STREET_NUMBER_INPUT);

  /**
   * Returns the welcome message shown at the beginning of the account creation process.
   *
   * @return the welcome message as a string
   */
  public static String getWelcomeText() {
    return InitialCreationScreen.welcomeText.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's first name
   */
  public static String getFirstNameText() {
    return InitialCreationScreen.firstNameInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's last name
   */
  public static String getLastNameText() {
    return InitialCreationScreen.lastNameInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's birth date
   */
  public static String getBirthDateInput() {
    return InitialCreationScreen.birthDateInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's city of birth
   */
  public static String getCityOfBirthText() {
    return InitialCreationScreen.cityOfBirthInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's tax ID
   */
  public static String getTaxIdText() {
    return InitialCreationScreen.taxIdInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's city of residence
   */
  public static String getAddressCityText() {
    return InitialCreationScreen.addressCityInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's postal code
   */
  public static String getAddressPostalCodeText() {
    return InitialCreationScreen.addressPostalCodeInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's street name
   */
  public static String getAddressStreetNameText() {
    return InitialCreationScreen.addressStreetNameInput.toString();
  }

  /**
   * @return the prompt asking the user to enter the customer's street number
   */
  public static String getAddressStreetNumberText() {
    return InitialCreationScreen.addressStreetNumberInput.toString();
  }
}
