package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import java.util.HashMap;
import java.util.Map;

public class BankAccountManager {

    private Map<BankId, SavingAccount> bankAccounts = new HashMap<>();

    public SavingAccount createBankAccount(
        BankId bankId,
        PositiveAmountEuro amountEuro
    ) {
        SavingAccount newBankAccount = new SavingAccount(bankId, amountEuro);
        this.bankAccounts.put(bankId, newBankAccount);
        return newBankAccount;
    }

    public SavingAccount createBankAccount(BankId bankId) {
        SavingAccount newBankAccount = new SavingAccount(bankId);
        this.bankAccounts.put(bankId, newBankAccount);
        return newBankAccount;
    }
}
