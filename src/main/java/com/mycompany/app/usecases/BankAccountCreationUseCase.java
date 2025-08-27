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
import com.mycompany.app.userconsole.BankAccountCreationUserConsole;
import com.mycompany.app.userconsole.valueobjects.CustomerUserConsoleInput;

import java.time.LocalDate;

public class BankAccountCreationUseCase {

  public static void execute() {
    BankAccountCreationUserConsole.printWelcomeMessage();
    BankAccountCreationUserConsole.printNewLine();
    BankAccountCreationUserConsole.printCustomerInformationNecessary();
    BankAccountCreationUserConsole.printNewLine();
    Customer customer = BankAccountCreationUseCase.createCustomerFromUserConsole();
    BankId bankId = new BankId();
    SavingAccount savingAccount = new SavingAccount(bankId);
    BankAccountCreationUserConsole.printNewLine();
    BankAccountCreationUserConsole.printBankAccountSuccessfullyCreated();
    BankAccountCreationUserConsole.printNewLine();
  }

  private static Customer createCustomerFromUserConsole() {
    CustomerUserConsoleInput customerInput = BankAccountCreationUserConsole.readCustomer();
    CustomerId customerId = new CustomerId();
    NormalizedString firstName = new NormalizedString(customerInput.firstName());
    NormalizedString lastName = new NormalizedString(customerInput.lastName());
    NormalizedString cityOfBirth = new NormalizedString(customerInput.cityOfBirth());
    LocalDate birthDate = LocalDate.parse(customerInput.birthDate());
    Address address =
        BankAccountCreationUseCase.createCustomerAddressFromUserConsole(customerInput);
    TaxId taxId = new TaxId(customerInput.taxId());

    return new Customer(customerId, firstName, lastName, cityOfBirth, birthDate, address, taxId);
  }

  private static Address createCustomerAddressFromUserConsole(
      CustomerUserConsoleInput customerInput) {
    NormalizedString city = new NormalizedString(customerInput.address().city());
    PostalCode postalCode = new PostalCode(customerInput.address().postalCode());
    StreetNumber streetNumber = new StreetNumber(customerInput.address().streetNumber());
    NormalizedString streetName = new NormalizedString(customerInput.address().streetName());
    return new Address(city, postalCode, streetNumber, streetName);
  }
}
