package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroNegativeValueException;

public class PositiveAmountEuro {

    private double positiveAmountEuro;

    public PositiveAmountEuro(double positiveAmountEuro) {
        this.positiveAmountEuro = positiveAmountEuro;
    }

    public double toDouble() {
        return this.positiveAmountEuro;
    }

    public PositiveAmountEuro add(PositiveAmountEuro otherPositiveAmountEuro) {
        double positiveAmountEuroSum =
            this.positiveAmountEuro + otherPositiveAmountEuro.toDouble();
        return new PositiveAmountEuro(positiveAmountEuroSum);
    }

    public PositiveAmountEuro subtract(
        PositiveAmountEuro otherPositiveAmountEuro
    ) throws PositiveAmountEuroNegativeValueException {
        double positiveAmountEuroSum =
            this.positiveAmountEuro - otherPositiveAmountEuro.toDouble();
        int smallestAllowedBalance = 0;
        if (positiveAmountEuroSum < smallestAllowedBalance) {
            throw new PositiveAmountEuroNegativeValueException(
                positiveAmountEuroSum
            );
        }
        return new PositiveAmountEuro(positiveAmountEuroSum);
    }
}
