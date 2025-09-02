package com.mycompany.app.usecases;

import com.mycompany.app.bankaccount.SavingAccount;
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

public class BankAccountCreationUseCase {

  public static final Scanner scanner = new Scanner(System.in);

  public static void execute() {
    System.out.print(InitialCreationScreen.getWelcomeText());
    System.out.println();
    System.out.println();
    Customer customer = readCustomerFromUserConsole();
    BankId bankId = new BankId();
    SavingAccount savingAccount = new SavingAccount(bankId);
    System.out.println();
    System.out.println();
    SuccessfulCreationScreen.setSuccessfulTextFormatting(
        customer.firstName().toString(), customer.lastName().toString(), bankId.toString());
    System.out.print(SuccessfulCreationScreen.getSuccessfulText());
    System.out.println();
    System.out.println();
  }

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

  private static NormalizedString readCustomerFirstName() {
    System.out.print(InitialCreationScreen.getFirstNameText());
    String firstNameString = scanner.nextLine();
    NormalizedString firstName = new NormalizedString(firstNameString);
    return firstName;
  }

  private static NormalizedString readCustomerLastName() {
    System.out.print(InitialCreationScreen.getLastNameText());
    String lastNameString = scanner.nextLine();
    NormalizedString lastName = new NormalizedString(lastNameString);
    return lastName;
  }

  private static NormalizedString readCustomerCityOfBirth() {
    System.out.print(InitialCreationScreen.getCityOfBirthText());
    String cityOfBirthString = scanner.nextLine();
    NormalizedString cityOfBirth = new NormalizedString(cityOfBirthString);
    return cityOfBirth;
  }

  private static LocalDate readCustomerBirthDate() {
    System.out.print(InitialCreationScreen.getBirthDateInput());
    String birthDateString = scanner.nextLine();
    LocalDate birthDate = LocalDate.parse(birthDateString);
    return birthDate;
  }

  private static TaxId readCustomerTaxId() {
    System.out.print(InitialCreationScreen.getTaxIdText());
    String taxIdString = scanner.nextLine();
    TaxId taxId = new TaxId(taxIdString);
    return taxId;
  }

  private static NormalizedString readCustomerAddressCity() {
    System.out.print(InitialCreationScreen.getAddressCityText());
    String addressCityString = scanner.nextLine();
    NormalizedString addressCity = new NormalizedString(addressCityString);
    return addressCity;
  }

  private static PostalCode readCustomerAddressPostalCode() {
    System.out.print(InitialCreationScreen.getAddressPostalCodeText());
    String addressPostalCodeString = scanner.nextLine();
    PostalCode addressPostalCode = new PostalCode(addressPostalCodeString);
    return addressPostalCode;
  }

  private static NormalizedString readCustomerAddressStreetName() {
    System.out.print(InitialCreationScreen.getAddressStreetNameText());
    String addressStreetNameString = scanner.nextLine();
    NormalizedString addressStreetName = new NormalizedString(addressStreetNameString);
    return addressStreetName;
  }

  private static StreetNumber readCustomerStreetNumber() {
    System.out.print(InitialCreationScreen.getAddressStreetNumberText());
    String addressStreetNumberString = scanner.nextLine();
    StreetNumber addressStreetName = new StreetNumber(addressStreetNumberString);
    return addressStreetName;
  }
}
