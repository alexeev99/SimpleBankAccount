package com.mycompany.app;

import com.mycompany.app.usecases.BankAccountCreationUseCase;
import com.mycompany.app.userconsole.screens.InitialScreen;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {

      System.out.print(InitialScreen.getText());
      String input = scanner.nextLine();
      System.out.println();
      System.out.println();

      switch (input) {
        case "1" -> BankAccountCreationUseCase.execute();
      }
    }
  }
}
