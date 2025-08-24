package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroNegativeValueException;

public class PositiveAmountEuro {

    private double positiveAmountEuro;
    private int SMALLEST_AMOUNT_EURO = 0;

    public PositiveAmountEuro(double positiveAmountEuro)
        throws PositiveAmountEuroNegativeValueException {
        this.validateAmountGreaterThanZero(positiveAmountEuro);
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
        this.validateAmountGreaterThanZero(positiveAmountEuroSum);
        return new PositiveAmountEuro(positiveAmountEuroSum);
    }

    private void validateAmountGreaterThanZero(double amountEuro)
        throws PositiveAmountEuroNegativeValueException {
        if (amountEuro < SMALLEST_AMOUNT_EURO) {
            throw new PositiveAmountEuroNegativeValueException(amountEuro);
        }
    }
}
