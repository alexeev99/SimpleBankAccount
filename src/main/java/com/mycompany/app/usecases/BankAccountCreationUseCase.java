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
import com.mycompany.app.userconsole.screens.BankAccountCreationScreen;
import java.time.LocalDate;
import java.util.Scanner;

public class BankAccountCreationUseCase {

  public static final Scanner scanner = new Scanner(System.in);

  public static void execute() {
    System.out.print(BankAccountCreationScreen.getWelcomeText());
    System.out.println();
    System.out.println();
    Customer customer = readCustomerFromUserConsole2();
    BankId bankId = new BankId();
    SavingAccount savingAccount = new SavingAccount(bankId);
  }

  private static Customer readCustomerFromUserConsole2() {
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
    System.out.print(BankAccountCreationScreen.getFirstNameText());
    String firstNameString = scanner.nextLine();
    NormalizedString firstName = new NormalizedString(firstNameString);
    return firstName;
  }

  private static NormalizedString readCustomerLastName() {
    System.out.print(BankAccountCreationScreen.getLastNameText());
    String lastNameString = scanner.nextLine();
    NormalizedString lastName = new NormalizedString(lastNameString);
    return lastName;
  }

  private static NormalizedString readCustomerCityOfBirth() {
    System.out.print(BankAccountCreationScreen.getCityOfBirthText());
    String cityOfBirthString = scanner.nextLine();
    NormalizedString cityOfBirth = new NormalizedString(cityOfBirthString);
    return cityOfBirth;
  }

  private static LocalDate readCustomerBirthDate() {
    System.out.print(BankAccountCreationScreen.getBirthDateInput());
    String birthDateString = scanner.nextLine();
    LocalDate birthDate = LocalDate.parse(birthDateString);
    return birthDate;
  }

  private static TaxId readCustomerTaxId() {
    System.out.print(BankAccountCreationScreen.getTaxIdText());
    String taxIdString = scanner.nextLine();
    TaxId taxId = new TaxId(taxIdString);
    return taxId;
  }

  private static NormalizedString readCustomerAddressCity() {
    System.out.print(BankAccountCreationScreen.getAddressCityText());
    String addressCityString = scanner.nextLine();
    NormalizedString addressCity = new NormalizedString(addressCityString);
    return addressCity;
  }

  private static PostalCode readCustomerAddressPostalCode() {
    System.out.print(BankAccountCreationScreen.getAddressPostalCodeText());
    String addressPostalCodeString = scanner.nextLine();
    PostalCode addressPostalCode = new PostalCode(addressPostalCodeString);
    return addressPostalCode;
  }

  private static NormalizedString readCustomerAddressStreetName() {
    System.out.print(BankAccountCreationScreen.getAddressStreetNameText());
    String addressStreetNameString = scanner.nextLine();
    NormalizedString addressStreetName = new NormalizedString(addressStreetNameString);
    return addressStreetName;
  }

  private static StreetNumber readCustomerStreetNumber() {
    System.out.print(BankAccountCreationScreen.getAddressStreetNumberText());
    String addressStreetNumberString = scanner.nextLine();
    StreetNumber addressStreetName = new StreetNumber(addressStreetNumberString);
    return addressStreetName;
  }
}
