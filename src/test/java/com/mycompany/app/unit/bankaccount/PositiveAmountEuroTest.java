package com.mycompany.app.unit.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroInvalidStringException;
import com.mycompany.app.bankaccount.exceptions.PositiveAmountEuroNegativeValueException;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PositiveAmountEuroTest {
  @Test
  void shouldCreatePositiveAmountEuroWhenUsingConstructorWithValidDoubleArgument() {
    Double positiveAmountEuroDouble = 10.0;
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroDouble);

    assertEquals(positiveAmountEuroDouble, positiveAmountEuro.toDouble());
  }

  @Test
  void shouldCreatePositiveAmountEuroWhenUsingConstructorWithValidStringArgument() {
    String positiveAmountEuroString = "10.0";
    Double positiveAmountEuroDouble = Double.parseDouble(positiveAmountEuroString);
    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroString);

    assertEquals(positiveAmountEuroDouble, positiveAmountEuro.toDouble());
  }

  @Test
  void shouldThrowExceptionWhenUsingConstructorWithDoubleSmallerThanZero() {
    Double positiveAmountEuroDouble = -1.0;
    String errorMessage =
        String.format(
            "The provided balance in Euro: '%.2f' cannot be negative.", positiveAmountEuroDouble);

    Executable newPositiveAmountEuroExecutable =
        () -> new PositiveAmountEuro(positiveAmountEuroDouble);

    PositiveAmountEuroNegativeValueException positiveAmountEuroNegativeValueException =
        assertThrows(
            PositiveAmountEuroNegativeValueException.class, newPositiveAmountEuroExecutable);

    assertEquals(errorMessage, positiveAmountEuroNegativeValueException.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenUsingConstructorWithInvalidString() {
    String positiveAmountEuroString = "invalid";
    String errorMessage =
        String.format(
            "Following given monetary amount: '%s' is invalid and could not be transformed to a"
                + " double.",
            positiveAmountEuroString);

    Executable newPositiveAmountEuroExecutable =
        () -> new PositiveAmountEuro(positiveAmountEuroString);

    PositiveAmountEuroInvalidStringException positiveAmountEuroInvalidStringException =
        assertThrows(
            PositiveAmountEuroInvalidStringException.class, newPositiveAmountEuroExecutable);
    assertEquals(errorMessage, positiveAmountEuroInvalidStringException.getMessage());
  }

  @Test
  void shouldThrowExceptionWhenUsingConstructorWithStringSmallerThanZero() {
    String positiveAmountEuroString = "-1.0";
    Double positiveAmountEuroDouble = -1.0;

    String errorMessage =
        String.format(
            "The provided balance in Euro: '%.2f' cannot be negative.", positiveAmountEuroDouble);

    Executable newPositiveAmountEuroExecutable =
        () -> new PositiveAmountEuro(positiveAmountEuroString);

    PositiveAmountEuroNegativeValueException positiveAmountEuroInvalidStringException =
        assertThrows(
            PositiveAmountEuroNegativeValueException.class, newPositiveAmountEuroExecutable);
    assertEquals(errorMessage, positiveAmountEuroInvalidStringException.getMessage());
  }

  @Test
  void shouldAddAnotherPositiveAmountEuro() {
    Double positiveAmountEuroDouble = 10.0;
    Double otherPositiveAmountEuroDouble = 20.0;
    Double resultPositiveAmountEuroDouble =
        positiveAmountEuroDouble + otherPositiveAmountEuroDouble;

    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroDouble);
    PositiveAmountEuro otherPositiveAmountEuro =
        new PositiveAmountEuro(otherPositiveAmountEuroDouble);

    PositiveAmountEuro resultPositiveAmountEuro = positiveAmountEuro.add(otherPositiveAmountEuro);

    assertEquals(resultPositiveAmountEuro.toDouble(), resultPositiveAmountEuroDouble);
  }

  @Test
  void shouldSubtractAnotherPositiveAmountEuro() {
    Double positiveAmountEuroDouble = 20.0;
    Double otherPositiveAmountEuroDouble = 10.0;
    Double resultPositiveAmountEuroDouble =
        positiveAmountEuroDouble - otherPositiveAmountEuroDouble;

    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroDouble);
    PositiveAmountEuro otherPositiveAmountEuro =
        new PositiveAmountEuro(otherPositiveAmountEuroDouble);

    PositiveAmountEuro resultPositiveAmountEuro =
        positiveAmountEuro.subtract(otherPositiveAmountEuro);

    assertEquals(resultPositiveAmountEuro.toDouble(), resultPositiveAmountEuroDouble);
  }

  @Test
  void shouldThrowExceptionWhenSubtractingLeadsToNegativeAmount() {

    Double positiveAmountEuroDouble = 10.0;
    Double otherPositiveAmountEuroDouble = 20.0;
    Double resultPositiveAmountEuroDouble =
        positiveAmountEuroDouble - otherPositiveAmountEuroDouble;

    String errorMessage =
        String.format(
            "The provided balance in Euro: '%.2f' cannot be negative.",
            resultPositiveAmountEuroDouble);

    PositiveAmountEuro positiveAmountEuro = new PositiveAmountEuro(positiveAmountEuroDouble);
    PositiveAmountEuro otherPositiveAmountEuro =
        new PositiveAmountEuro(otherPositiveAmountEuroDouble);

    Executable newPositiveAmountEuroExecutable =
        () -> positiveAmountEuro.subtract(otherPositiveAmountEuro);

    PositiveAmountEuroNegativeValueException positiveAmountEuroInvalidStringException =
        assertThrows(
            PositiveAmountEuroNegativeValueException.class, newPositiveAmountEuroExecutable);
    assertEquals(errorMessage, positiveAmountEuroInvalidStringException.getMessage());
  }
}
