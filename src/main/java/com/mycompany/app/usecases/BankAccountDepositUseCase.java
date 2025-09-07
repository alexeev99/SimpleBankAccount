package com.mycompany.app.usecases;

import com.mycompany.app.bankaccount.BankAccountManagerSingleton;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import com.mycompany.app.userconsole.screens.depositscreens.InitialDepositScreen;
import com.mycompany.app.userconsole.screens.depositscreens.SuccessfulDepositScreen;
import java.util.Scanner;

/**
 * Represents the use case for depositing money into an existing bank account. <br>
 * <br>
 * This workflow interacts with the user via the console, requesting the bank ID and the deposit
 * amount in euros. It then delegates the actual deposit operation to the {@link
 * BankAccountManagerSingleton}, and finally displays a confirmation message through the {@link
 * SuccessfulDepositScreen}.
 *
 * <p>The process flow is as follows:
 *
 * <ol>
 *   <li>Display the deposit welcome screen
 *   <li>Prompt the user for the bank ID
 *   <li>Look up the corresponding bank account
 *   <li>Prompt the user for the deposit amount
 *   <li>Perform the deposit
 *   <li>Display a success message with the deposited amount and bank ID
 * </ol>
 *
 * <p>Typical usage example:
 *
 * <pre>{@code
 * BankAccountDepositUseCase.execute();
 * }</pre>
 */
public class BankAccountDepositUseCase {

  /** Shared {@link Scanner} for reading user input from the console. */
  public static final Scanner scanner = new Scanner(System.in);

  /**
   * Executes the deposit use case by guiding the user through the deposit process, performing the
   * deposit, and displaying a confirmation message.
   */
  public static void execute() {
    System.out.print(InitialDepositScreen.getWelcomeText());
    System.out.println();
    System.out.println();

    BankId bankId = BankAccountDepositUseCase.readBankId();
    BankAccountManagerSingleton bankAccountManager = BankAccountManagerSingleton.getInstance();
    bankAccountManager.find(bankId);
    PositiveAmountEuro positiveAmountEuro = BankAccountDepositUseCase.readPositiveAmountEuro();
    System.out.println();
    System.out.println();

    bankAccountManager.deposit(bankId, positiveAmountEuro);

    SuccessfulDepositScreen.setSuccessfulTextFormatting(
        positiveAmountEuro.toDouble(), bankId.toString());
    System.out.print(SuccessfulDepositScreen.getSuccessfulText());
    System.out.println();
    System.out.println();
  }

  /**
   * Reads the bank ID from the user console and returns it as a {@link BankId}.
   *
   * @return a {@code BankId} created from user input
   */
  private static BankId readBankId() {
    System.out.print(InitialDepositScreen.getBankIdText());
    String bankIdString = scanner.nextLine();
    BankId bankId = new BankId(bankIdString);
    return bankId;
  }

  /**
   * Reads the deposit amount in euros from the user console and returns it as a {@link
   * PositiveAmountEuro}.
   *
   * @return a {@code PositiveAmountEuro} created from user input
   */
  private static PositiveAmountEuro readPositiveAmountEuro() {
    System.out.print(InitialDepositScreen.getMonetaryAmountEurText());
    String positiveAmountEuroString = scanner.nextLine();
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroString);
    return positiveAmountEuro;
  }
}
