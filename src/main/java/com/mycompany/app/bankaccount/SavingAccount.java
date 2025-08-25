package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroNegativeValueException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;

public class SavingAccount extends BankAccount {

    public SavingAccount(BankId bankId, PositiveAmountEuro amountEuro) {
        super(bankId, amountEuro);
        this.amountEuro = amountEuro;
        this.bankId = bankId;
    }

    public SavingAccount(BankId bankId) {
        super(bankId);
        this.bankId = bankId;
    }

    public PositiveAmountEuro withdraw(PositiveAmountEuro amountEuro) {
        PositiveAmountEuro newAmountEuro;
        try {
            newAmountEuro = this.amountEuro.subtract(amountEuro);
        } catch (PositiveAmountEuroNegativeValueException e) {
            throw new BankAccountNegativeAmountEuroWithdrawException(
                amountEuro.toDouble()
            );
        }
        this.amountEuro = newAmountEuro;
        return newAmountEuro;
    }

    public void deposit(PositiveAmountEuro amountEuro) {
        this.amountEuro = this.amountEuro.add(amountEuro);
    }

    public PositiveAmountEuro balance() {
        return this.amountEuro;
    }

    public BankId getBankId() {
        return this.bankId;
    }
}
