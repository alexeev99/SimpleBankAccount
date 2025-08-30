package com.mycompany.app.userconsole.screens;

import com.mycompany.app.userconsole.UserConsoleScreen;

public class BankAccountCreationScreen {
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

  public static String getWelcomeText() {
    return BankAccountCreationScreen.welcomeText.toString();
  }

  public static String getFirstNameText() {
    return BankAccountCreationScreen.firstNameInput.toString();
  }

  public static String getLastNameText() {
    return BankAccountCreationScreen.lastNameInput.toString();
  }

  public static String getBirthDateInput() {
    return BankAccountCreationScreen.birthDateInput.toString();
  }

  public static String getCityOfBirthText() {
    return BankAccountCreationScreen.cityOfBirthInput.toString();
  }

  public static String getTaxIdText() {
    return BankAccountCreationScreen.taxIdInput.toString();
  }

  public static String getAddressCityText() {
    return BankAccountCreationScreen.addressCityInput.toString();
  }

  public static String getAddressPostalCodeText() {
    return BankAccountCreationScreen.addressPostalCodeInput.toString();
  }

  public static String getAddressStreetNameText() {
    return BankAccountCreationScreen.addressStreetNameInput.toString();
  }

  public static String getAddressStreetNumberText() {
    return BankAccountCreationScreen.addressStreetNumberInput.toString();
  }
}
