package com.mycompany.app.usecases;

import com.mycompany.app.userconsole.screens.depositscreens.InitialDepositScreen;
import java.util.Scanner;

public class BankAccountDepositUseCase {

  public static final Scanner scanner = new Scanner(System.in);

  public static void execute() {
    System.out.print(InitialDepositScreen.getWelcomeText());
    System.out.println();
    System.out.println();
  }
}
