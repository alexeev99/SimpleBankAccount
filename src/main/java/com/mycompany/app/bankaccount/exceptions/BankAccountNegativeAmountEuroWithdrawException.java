package com.mycompany.app.bankaccount.exceptions;

public class BankAccountNegativeAmountEuroWithdrawException
    extends RuntimeException {

    public BankAccountNegativeAmountEuroWithdrawException(double amountEuro) {
        super(
            String.format(
                "A negative amount %.2f cannot be withdrawn.",
                amountEuro
            )
        );
    }
}
