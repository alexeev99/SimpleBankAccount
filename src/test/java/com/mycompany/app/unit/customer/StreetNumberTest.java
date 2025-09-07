package com.mycompany.app.unit.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.customer.exceptions.StreetNumberNotIntegerException;
import com.mycompany.app.customer.valueobjects.StreetNumber;

import org.junit.jupiter.api.Test;

class StreetNumberTest {

  @Test
  void shouldAcceptValidStreetNumber() {
    StreetNumber streetNumber = new StreetNumber("123");
    assertEquals("123", streetNumber.toString());
  }

  @Test
  void shouldAcceptZeroAsStreetNumber() {
    StreetNumber streetNumber = new StreetNumber("0");
    assertEquals("0", streetNumber.toString());
  }

  @Test
  void shouldThrowExceptionWhenStreetNumberContainsLetters() {
    String raw = "12A";
    assertThrows(StreetNumberNotIntegerException.class, () -> new StreetNumber(raw));
  }

  @Test
  void shouldThrowExceptionWhenStreetNumberContainsSpecialCharacters() {
    String raw = "12-4";
    assertThrows(StreetNumberNotIntegerException.class, () -> new StreetNumber(raw));
  }

  @Test
  void shouldThrowExceptionWhenStreetNumberIsEmpty() {
    String raw = "";
    assertThrows(StreetNumberNotIntegerException.class, () -> new StreetNumber(raw));
  }

  @Test
  void shouldThrowExceptionWhenStreetNumberIsWhitespace() {
    String raw = "   ";
    assertThrows(StreetNumberNotIntegerException.class, () -> new StreetNumber(raw));
  }
}
