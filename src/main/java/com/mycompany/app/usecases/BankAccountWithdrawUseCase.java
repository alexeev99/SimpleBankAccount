package com.mycompany.app.usecases;

import com.mycompany.app.bankaccount.BankAccountManagerSingleton;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import com.mycompany.app.userconsole.screens.withdrawscreens.InitialWithdrawScreen;
import com.mycompany.app.userconsole.screens.withdrawscreens.SuccessfulWithdrawScreen;

import java.util.Scanner;

public class BankAccountWithdrawUseCase {
  public static final Scanner scanner = new Scanner(System.in);

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
