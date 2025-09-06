package com.mycompany.app.usecases;

import com.mycompany.app.bankaccount.BankAccountManagerSingleton;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import com.mycompany.app.userconsole.screens.depositscreens.InitialDepositScreen;
import com.mycompany.app.userconsole.screens.depositscreens.SuccessfulDepositScreen;
import java.util.Scanner;

public class BankAccountDepositUseCase {

  public static final Scanner scanner = new Scanner(System.in);

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

  private static BankId readBankId() {
    System.out.print(InitialDepositScreen.getBankIdText());
    String bankIdString = scanner.nextLine();
    BankId bankId = new BankId(bankIdString);
    return bankId;
  }

  private static PositiveAmountEuro readPositiveAmountEuro() {
    System.out.print(InitialDepositScreen.getMonetaryAmountEurText());
    String positiveAmountEuroString = scanner.nextLine();
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroString);
    return positiveAmountEuro;
  }
}
