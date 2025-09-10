package com.mycompany.app.usecases;

import com.mycompany.app.bankaccount.BankAccountManagerSingleton;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import com.mycompany.app.userconsole.screens.withdrawscreens.InitialWithdrawScreen;
import com.mycompany.app.userconsole.screens.withdrawscreens.SuccessfulWithdrawScreen;

import java.util.Scanner;

/**
 * Use case for handling the withdrawal of money from a bank account. <br>
 * <br>
 * This class orchestrates the withdrawal process in a console-driven flow:
 *
 * <ol>
 *   <li>Display the withdrawal welcome screen
 *   <li>Prompt the user for a bank account ID and validate it
 *   <li>Prompt the user for a positive withdrawal amount
 *   <li>Perform the withdrawal through {@link BankAccountManagerSingleton}
 *   <li>Retrieve the updated account balance
 *   <li>Display a formatted success message with withdrawal details
 * </ol>
 *
 * <p>The withdrawal process is interactive and depends on user input provided via the console.
 */
public class BankAccountWithdrawUseCase {

  public static final Scanner scanner = new Scanner(System.in);

  /**
   * Executes the full withdrawal use case. <br>
   * <br>
   * This includes showing introductory text, reading and validating user input, performing the
   * withdrawal, and displaying the confirmation message.
   */
  public static void execute() {
    System.out.print(InitialWithdrawScreen.getWelcomeText());
    System.out.println();
    System.out.println();

    BankId bankId = BankAccountWithdrawUseCase.readBankId();

    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();
    bankAccountManager.find(bankId);

    PositiveAmountEuro withdrawnAmountEuro = BankAccountWithdrawUseCase.readPositiveAmountEuro();
    System.out.println();
    System.out.println();

    bankAccountManager.withdraw(bankId, withdrawnAmountEuro);

    PositiveAmountEuro newAmountEuro = bankAccountManager.getBalance(bankId);

    SuccessfulWithdrawScreen.setSuccessfulTextFormatting(
        withdrawnAmountEuro.toDouble(), newAmountEuro.toDouble(), bankId.toString());

    System.out.print(SuccessfulWithdrawScreen.getSuccessfulText());
    System.out.println();
    System.out.println();
  }

  private static BankId readBankId() {
    System.out.print(InitialWithdrawScreen.getBankIdText());
    String bankIdString = scanner.nextLine();
    BankId bankId = new BankId(bankIdString);
    return bankId;
  }

  private static PositiveAmountEuro readPositiveAmountEuro() {
    System.out.print(InitialWithdrawScreen.getMonetaryAmountEurText());
    String positiveAmountEuroString = scanner.nextLine();
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroString);
    return positiveAmountEuro;
  }
}
