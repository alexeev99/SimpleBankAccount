package com.mycompany.app.usecases;

import com.mycompany.app.bankaccount.BankAccountManagerSingleton;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.customer.valueobjects.Address;
import com.mycompany.app.customer.valueobjects.Customer;
import com.mycompany.app.customer.valueobjects.CustomerId;
import com.mycompany.app.customer.valueobjects.NormalizedString;
import com.mycompany.app.customer.valueobjects.PostalCode;
import com.mycompany.app.customer.valueobjects.StreetNumber;
import com.mycompany.app.customer.valueobjects.TaxId;
import com.mycompany.app.userconsole.screens.creationscreens.InitialCreationScreen;
import com.mycompany.app.userconsole.screens.creationscreens.SuccessfulCreationScreen;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Represents the use case for creating a new bank account. <br>
 * <br>
 * This workflow interacts with the user via the console, prompting for customer details such as
 * name, birth date, address, and tax ID. A {@link Customer} is created from the collected data, a
 * new {@link BankId} is generated, and the account is persisted using the {@link
 * BankAccountManagerSingleton}. Finally, a confirmation message is displayed through the {@link
 * SuccessfulCreationScreen}.
 *
 * <p>The process flow is as follows:
 *
 * <ol>
 *   <li>Display the welcome screen for account creation
 *   <li>Collect customer information step by step from console input
 *   <li>Create a {@code Customer} aggregate
 *   <li>Generate a new {@code BankId} and persist the account
 *   <li>Show a success message containing the customer name and bank ID
 * </ol>
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * BankAccountCreationUseCase.execute();
 * }</pre>
 */
public class BankAccountCreationUseCase {

  /** Shared {@link Scanner} for reading user input from the console. */
  public static final Scanner scanner = new Scanner(System.in);

  /**
   * Executes the bank account creation workflow: displays the initial screen, collects customer
   * details, creates a new bank account, and prints a confirmation message.
   */
  public static void execute() {
    System.out.print(InitialCreationScreen.getWelcomeText());
    System.out.println();
    System.out.println();

    Customer customer = readCustomerFromUserConsole();
    BankId bankId = new BankId();

    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();
    bankAccountManager.create(bankId);

    SuccessfulCreationScreen.setSuccessfulTextFormatting(
        customer.firstName().toString(), customer.lastName().toString(), bankId.toString());

    System.out.println();
    System.out.println();

    System.out.print(SuccessfulCreationScreen.getSuccessfulText());
    System.out.println();
    System.out.println();
  }

  /**
   * Reads all required customer data from the user console and constructs a {@link Customer}
   * object.
   *
   * @return a newly created {@code Customer} instance
   */
  private static Customer readCustomerFromUserConsole() {
    CustomerId customerId = new CustomerId();
    NormalizedString firstName = readCustomerFirstName();
    NormalizedString lastName = readCustomerLastName();
    NormalizedString cityOfBirth = readCustomerCityOfBirth();
    LocalDate birthDate = readCustomerBirthDate();
    TaxId taxId = readCustomerTaxId();
    NormalizedString addressCity = readCustomerAddressCity();
    PostalCode addressPostalCode = readCustomerAddressPostalCode();
    NormalizedString addressStreetName = readCustomerAddressStreetName();
    StreetNumber addressStreetNumber = readCustomerStreetNumber();

    Address address =
        new Address(addressCity, addressPostalCode, addressStreetNumber, addressStreetName);
    return new Customer(customerId, firstName, lastName, cityOfBirth, birthDate, address, taxId);
  }

  /**
   * Prompts the user for the customer's first name and returns it as a {@link NormalizedString}.
   *
   * @return the customer's first name
   */
  private static NormalizedString readCustomerFirstName() {
    System.out.print(InitialCreationScreen.getFirstNameText());
    String firstNameString = scanner.nextLine();
    return new NormalizedString(firstNameString);
  }

  /**
   * Prompts the user for the customer's last name and returns it as a {@link NormalizedString}.
   *
   * @return the customer's last name
   */
  private static NormalizedString readCustomerLastName() {
    System.out.print(InitialCreationScreen.getLastNameText());
    String lastNameString = scanner.nextLine();
    return new NormalizedString(lastNameString);
  }

  /**
   * Prompts the user for the customer's city of birth.
   *
   * @return the city of birth as a {@link NormalizedString}
   */
  private static NormalizedString readCustomerCityOfBirth() {
    System.out.print(InitialCreationScreen.getCityOfBirthText());
    String cityOfBirthString = scanner.nextLine();
    return new NormalizedString(cityOfBirthString);
  }

  /**
   * Prompts the user for the customer's birth date and parses it as a {@link LocalDate}.
   *
   * @return the customer's birth date
   */
  private static LocalDate readCustomerBirthDate() {
    System.out.print(InitialCreationScreen.getBirthDateInput());
    String birthDateString = scanner.nextLine();
    return LocalDate.parse(birthDateString);
  }

  /**
   * Prompts the user for the customer's tax ID.
   *
   * @return the customer's tax ID as a {@link TaxId}
   */
  private static TaxId readCustomerTaxId() {
    System.out.print(InitialCreationScreen.getTaxIdText());
    String taxIdString = scanner.nextLine();
    return new TaxId(taxIdString);
  }

  /**
   * Prompts the user for the customer's city of residence.
   *
   * @return the customer's address city as a {@link NormalizedString}
   */
  private static NormalizedString readCustomerAddressCity() {
    System.out.print(InitialCreationScreen.getAddressCityText());
    String addressCityString = scanner.nextLine();
    return new NormalizedString(addressCityString);
  }

  /**
   * Prompts the user for the customer's postal code.
   *
   * @return the customer's postal code as a {@link PostalCode}
   */
  private static PostalCode readCustomerAddressPostalCode() {
    System.out.print(InitialCreationScreen.getAddressPostalCodeText());
    String addressPostalCodeString = scanner.nextLine();
    return new PostalCode(addressPostalCodeString);
  }

  /**
   * Prompts the user for the customer's street name.
   *
   * @return the customer's street name as a {@link NormalizedString}
   */
  private static NormalizedString readCustomerAddressStreetName() {
    System.out.print(InitialCreationScreen.getAddressStreetNameText());
    String addressStreetNameString = scanner.nextLine();
    return new NormalizedString(addressStreetNameString);
  }

  /**
   * Prompts the user for the customer's street number.
   *
   * @return the customer's street number as a {@link StreetNumber}
   */
  private static StreetNumber readCustomerStreetNumber() {
    System.out.print(InitialCreationScreen.getAddressStreetNumberText());
    String addressStreetNumberString = scanner.nextLine();
    return new StreetNumber(addressStreetNumberString);
  }
}
