package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroInvalidStringException;
import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroNegativeValueException;

/**
 * Represents a strictly positive monetary amount in euros. <br>
 * <br>
 * A {@code PositiveAmountEuro} enforces domain rules ensuring that amounts cannot be negative and
 * can be constructed from either a {@code double} or a string representation.
 *
 * <p>This class provides arithmetic operations such as addition and subtraction while preserving
 * the invariant of non-negative values.
 */
public class PositiveAmountEuro {

  private double positiveAmountEuro;
  private static int SMALLEST_AMOUNT_EURO = 0;

  /**
   * Creates a new {@code PositiveAmountEuro} from a double value.
   *
   * @param positiveAmountEuro the monetary amount in euros
   * @throws PositiveAmountEuroNegativeValueException if the amount is negative
   */
  public PositiveAmountEuro(double positiveAmountEuro)
      throws PositiveAmountEuroNegativeValueException {
    this.validateAmountGreaterThanZero(positiveAmountEuro);
    this.positiveAmountEuro = positiveAmountEuro;
  }

  /**
   * Creates a new {@code PositiveAmountEuro} from a string value.
   *
   * @param positiveAmountEuro the string representation of the amount
   * @throws PositiveAmountEuroNegativeValueException if the amount is negative
   * @throws PositiveAmountEuroInvalidStringException if the string cannot be parsed as a double
   */
  public PositiveAmountEuro(String positiveAmountEuro)
      throws PositiveAmountEuroNegativeValueException, PositiveAmountEuroInvalidStringException {
    Double positiveAmountEuroDouble = this.transformStringToDouble(positiveAmountEuro);
    this.validateAmountGreaterThanZero(positiveAmountEuroDouble);
    this.positiveAmountEuro = positiveAmountEuroDouble;
  }

  /**
   * Returns the amount as a primitive {@code double}.
   *
   * @return the monetary amount
   */
  public double toDouble() {
    return this.positiveAmountEuro;
  }

  /**
   * Adds this amount to another positive amount and returns a new instance.
   *
   * @param otherPositiveAmountEuro the amount to add
   * @return a new {@code PositiveAmountEuro} with the summed value
   */
  public PositiveAmountEuro add(PositiveAmountEuro otherPositiveAmountEuro) {
    double positiveAmountEuroSum = this.positiveAmountEuro + otherPositiveAmountEuro.toDouble();
    return new PositiveAmountEuro(positiveAmountEuroSum);
  }

  /**
   * Subtracts another positive amount from this one and returns a new instance.
   *
   * @param otherPositiveAmountEuro the amount to subtract
   * @return a new {@code PositiveAmountEuro} with the result
   * @throws PositiveAmountEuroNegativeValueException if the result would be negative
   */
  public PositiveAmountEuro subtract(PositiveAmountEuro otherPositiveAmountEuro)
      throws PositiveAmountEuroNegativeValueException {
    double positiveAmountEuroSum = this.positiveAmountEuro - otherPositiveAmountEuro.toDouble();
    this.validateAmountGreaterThanZero(positiveAmountEuroSum);
    return new PositiveAmountEuro(positiveAmountEuroSum);
  }

  private void validateAmountGreaterThanZero(double amountEuro)
      throws PositiveAmountEuroNegativeValueException {
    if (amountEuro < SMALLEST_AMOUNT_EURO) {
      throw new PositiveAmountEuroNegativeValueException(amountEuro);
    }
  }

  private double transformStringToDouble(String amountEuro)
      throws PositiveAmountEuroInvalidStringException {
    try {
      return Double.parseDouble(amountEuro);
    } catch (NumberFormatException e) {
      throw new PositiveAmountEuroInvalidStringException(amountEuro);
    }
  }
}
