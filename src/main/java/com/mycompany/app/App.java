package com.mycompany.app;

import com.mycompany.app.usecases.BankAccountCreationUseCase;
import com.mycompany.app.usecases.BankAccountDepositUseCase;
import com.mycompany.app.usecases.BankAccountWithdrawUseCase;
import com.mycompany.app.userconsole.screens.InitialScreen;
import com.mycompany.app.userconsole.screens.InvalidOperationScreen;
import com.mycompany.app.userconsole.screens.TerminationScreen;

import java.util.Scanner;

/**
 * Entry point for the SimpleBankApp console application. <br>
 * <br>
 * The {@code App} class provides a simple text-based menu loop that allows users to perform various
 * banking operations. Depending on user input, different use cases are triggered.
 *
 * <p>The available options are:
 *
 * <ul>
 *   <li><b>1</b> – Create a new bank account (via {@link BankAccountCreationUseCase})
 *   <li><b>2</b> – Deposit money into an existing account (via {@link BankAccountDepositUseCase})
 *   <li><b>c</b> – Terminate the application (via {@link TerminationScreen})
 *   <li>Any other input – Show an invalid operation message (via {@link InvalidOperationScreen})
 * </ul>
 *
 * <p>The loop continues until the user explicitly chooses to terminate the application.
 */
public class App {

  /**
   * Main entry point of the application. <br>
   * Displays the initial screen, reads user input, and executes the corresponding use case until
   * termination is requested.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {

      System.out.print(InitialScreen.getText());
      String input = scanner.nextLine();
      System.out.println();
      System.out.println();

      switch (input) {
        case "1" -> BankAccountCreationUseCase.execute();
        case "2" -> BankAccountDepositUseCase.execute();
        case "3" -> BankAccountWithdrawUseCase.execute();
        case "c" -> {
          System.out.print(TerminationScreen.getText());
          return;
        }
        default -> {
          System.out.print(InvalidOperationScreen.getText());
          System.out.println();
          System.out.println();
        }
      }
    }
  }
}
