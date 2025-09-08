package com.mycompany.app.unit.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.customer.exceptions.TaxIdInvalidFormatException;
import com.mycompany.app.customer.valueobjects.TaxId;

import org.junit.jupiter.api.Test;

class TaxIdTest {

  @Test
  void shouldAcceptValidTaxId() {
    TaxId taxId = new TaxId("12345678901");
    assertEquals("12345678901", taxId.toString());
  }

  @Test
  void shouldThrowExceptionWhenTaxIdTooShort() {
    String raw = "1234567890"; // 10 digits
    assertThrows(TaxIdInvalidFormatException.class, () -> new TaxId(raw));
  }

  @Test
  void shouldThrowExceptionWhenTaxIdTooLong() {
    String raw = "123456789012"; // 12 digits
    assertThrows(TaxIdInvalidFormatException.class, () -> new TaxId(raw));
  }

  @Test
  void shouldThrowExceptionWhenTaxIdContainsLetters() {
    String raw = "12345A78901";
    assertThrows(TaxIdInvalidFormatException.class, () -> new TaxId(raw));
  }

  @Test
  void shouldThrowExceptionWhenTaxIdContainsSpecialCharacters() {
    String raw = "12345-78901";
    assertThrows(TaxIdInvalidFormatException.class, () -> new TaxId(raw));
  }

  @Test
  void shouldThrowExceptionWhenTaxIdIsEmpty() {
    String raw = "";
    assertThrows(TaxIdInvalidFormatException.class, () -> new TaxId(raw));
  }

  @Test
  void shouldThrowExceptionWhenTaxIdIsWhitespace() {
    String raw = "           "; // 11 spaces
    assertThrows(TaxIdInvalidFormatException.class, () -> new TaxId(raw));
  }
}
