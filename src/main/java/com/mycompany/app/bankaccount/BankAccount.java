package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import com.mycompany.app.bankaccount.valueobjects.Transaction;
import java.util.HashMap;
import java.util.Map;

public abstract class BankAccount {

    protected Map<String, Transaction> transactions = new HashMap<>();
    protected PositiveAmountEuro amountEuro = new PositiveAmountEuro(0);
    protected BankId bankId;

    protected BankAccount(BankId bankId, PositiveAmountEuro amountEuro) {}

    protected BankAccount(BankId bankId) {}

    public abstract PositiveAmountEuro withdraw(PositiveAmountEuro amountEuro)
        throws BankAccountNegativeAmountEuroWithdrawException;

    public abstract void deposit(PositiveAmountEuro amountEuro);

    public abstract PositiveAmountEuro balance();
}
