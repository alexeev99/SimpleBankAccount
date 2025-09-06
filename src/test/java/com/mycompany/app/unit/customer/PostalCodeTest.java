package com.mycompany.app.unit.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.customer.exceptions.PostalCodeInvalidFormatException;
import com.mycompany.app.customer.valueobjects.PostalCode;
import org.junit.jupiter.api.Test;

class PostalCodeTest {

  @Test
  void shouldAcceptValidPostalCode() {
    PostalCode postalCode = new PostalCode("12345");
    assertEquals("12345", postalCode.toString());
  }

  @Test
  void shouldThrowExceptionWhenPostalCodeTooShort() {
    String raw = "1234";
    assertThrows(PostalCodeInvalidFormatException.class, () -> new PostalCode(raw));
  }

  @Test
  void shouldThrowExceptionWhenPostalCodeTooLong() {
    String raw = "123456";
    assertThrows(PostalCodeInvalidFormatException.class, () -> new PostalCode(raw));
  }

  @Test
  void shouldThrowExceptionWhenPostalCodeContainsLetters() {
    String raw = "12a45";
    assertThrows(PostalCodeInvalidFormatException.class, () -> new PostalCode(raw));
  }

  @Test
  void shouldThrowExceptionWhenPostalCodeContainsSpecialChars() {
    String raw = "12-45";
    assertThrows(PostalCodeInvalidFormatException.class, () -> new PostalCode(raw));
  }

  @Test
  void shouldThrowExceptionWhenPostalCodeIsEmpty() {
    String raw = "";
    assertThrows(PostalCodeInvalidFormatException.class, () -> new PostalCode(raw));
  }
}
