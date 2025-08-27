package com.mycompany.app.userconsole;

import java.util.Scanner;

public class InitialUserConsole {

  private static final Scanner scanner = new Scanner(System.in);

  public static void printOperationMenu() {
    System.out.print("Welcome to the SimpleBankApp!\n");
    System.out.print("\n");
    System.out.print("With which operation do you want to proceed ?\n");
    System.out.print("\n");
    System.out.print("Type in the corresponding number (e.g. 1, 2, 3, ...)\n");
    System.out.print("in order to proceed with your chosen operation.\n");
    System.out.print("\n");
    System.out.print("1. Create a new Bank Account\n");
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
