package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.valueobjects.BankId;
import java.util.HashMap;
import java.util.Map;

public class BankAccountManager {

    private Map<BankId, SavingAccount> bankAccounts = new HashMap<>();

    public void addBankAccount(SavingAccount bankAccount) {
        this.bankAccounts.put(bankAccount.getBankId(), bankAccount);
    }
}
