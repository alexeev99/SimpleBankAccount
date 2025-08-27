package com.mycompany.app.userconsole;

import com.mycompany.app.userconsole.valueobjects.CustomerAddressUserConsoleInput;
import com.mycompany.app.userconsole.valueobjects.CustomerUserConsoleInput;
import java.util.Scanner;

public class BankAccountCreationUserConsole {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printWelcomeMessage() {
        System.out.print("Welcome to bank account creation process!\n");
    }

    public static void printCustomerInformationNecessary() {
        System.out.print("As the first step, please type in the necessary\n");
        System.out.print("customer information\n");
    }

    public static void printBankAccountSuccessfullyCreated() {
        System.out.print("Successfully created a saving bank account\n");
    }

    public static CustomerUserConsoleInput readCustomer() {
        CustomerAddressUserConsoleInput address =
            BankAccountCreationUserConsole.readCustomerAddress();
        String firstName =
            BankAccountCreationUserConsole.readCustomerFirstName();
        String lastName = BankAccountCreationUserConsole.readCustomerLastName();
        String cityOfBirth =
            BankAccountCreationUserConsole.readCustomerCityOfBirth();
        String birthDate =
            BankAccountCreationUserConsole.readCustomerBirthDate();
        String taxId = BankAccountCreationUserConsole.readCustomerTaxId();
        return new CustomerUserConsoleInput(
            firstName,
            lastName,
            cityOfBirth,
            birthDate,
            taxId,
            address
        );
    }

    public static CustomerAddressUserConsoleInput readCustomerAddress() {
        String city = BankAccountCreationUserConsole.readCustomerAddressCity();
        String postalCode =
            BankAccountCreationUserConsole.readCustomerAddressPostalCode();
        String streetNumber =
            BankAccountCreationUserConsole.readCustomerAddressStreetNumber();
        String streetName =
            BankAccountCreationUserConsole.readCustomerAddressStreetName();
        return new CustomerAddressUserConsoleInput(
            city,
            postalCode,
            streetNumber,
            streetName
        );
    }

    public static String readCustomerFirstName() {
        System.out.print("First name: ");
        return scanner.nextLine();
    }

    public static String readCustomerLastName() {
        System.out.print("Last name: ");
        return scanner.nextLine();
    }

    public static String readCustomerCityOfBirth() {
        System.out.print("City of birth: ");
        return scanner.nextLine();
    }

    public static String readCustomerBirthDate() {
        System.out.print("Birth date (YYYY-MM-DD): ");
        return scanner.nextLine();
    }

    public static String readCustomerTaxId() {
        System.out.print("Tax ID: ");
        return scanner.nextLine();
    }

    public static String readCustomerAddressCity() {
        System.out.print("City of residence: ");
        return scanner.nextLine();
    }

    public static String readCustomerAddressPostalCode() {
        System.out.print("Postal code: ");
        return scanner.nextLine();
    }

    public static String readCustomerAddressStreetNumber() {
        System.out.print("Street number: ");
        return scanner.nextLine();
    }

    public static String readCustomerAddressStreetName() {
        System.out.print("Street name: ");
        return scanner.nextLine();
    }

    public static void printNewLine() {
        System.out.print("\n");
    }

    public static void printTerminationHint() {
        System.out.print("Type in 'c' in order to terminate the application\n");
    }

    public static void printTerminationNotification() {
        System.out.print("Terminating the application!\n");
    }

    public static void printInvalidInput() {
        System.out.print("Invalid input inserted!\n");
    }

    public static String readUserInput() {
        System.out.print("Your input: ");
        return scanner.nextLine();
    }
}
