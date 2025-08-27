package com.mycompany.app;

import com.mycompany.app.usecases.BankAccountCreationUseCase;
import com.mycompany.app.userconsole.InitialUserConsole;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        while (true) {
            String state = "initial";
            InitialUserConsole.printOperationMenu();
            InitialUserConsole.printNewLine();
            InitialUserConsole.printTerminationHint();
            InitialUserConsole.printNewLine();

            String nextOperation = InitialUserConsole.readUserInput().trim();
            InitialUserConsole.printNewLine();
            InitialUserConsole.printNewLine();

            if ("initial".equals(state)) {
                if ("1".equals(nextOperation)) {
                    state = "createBankAccount";
                } else if ("c".equals(nextOperation)) {
                    InitialUserConsole.printTerminationNotification();
                    break;
                } else {
                    InitialUserConsole.printInvalidInput();
                    InitialUserConsole.printNewLine();
                    InitialUserConsole.printNewLine();
                    InitialUserConsole.printNewLine();
                }
            }

            if ("createBankAccount".equals(state)) {
                BankAccountCreationUseCase.execute();
            }
        }
    }
}
