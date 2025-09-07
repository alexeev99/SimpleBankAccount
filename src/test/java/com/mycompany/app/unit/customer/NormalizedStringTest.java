package com.mycompany.app.unit.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.customer.exceptions.NormalizedStringEmptyInputException;
import com.mycompany.app.customer.valueobjects.NormalizedString;

import org.junit.jupiter.api.Test;

class NormalizedStringTest {

  @Test
  void shouldTrimAndLowercaseInput() {
    String raw = "   HeLLo WoRLd   ";
    NormalizedString normalized = new NormalizedString(raw);

    assertEquals("hello world", normalized.toString());
  }

  @Test
  void shouldKeepAlreadyNormalizedStringUntouched() {
    String raw = "java";
    NormalizedString normalized = new NormalizedString(raw);

    assertEquals("java", normalized.toString());
  }

  @Test
  void shouldThrowExceptionWhenInputIsEmptyString() {
    String raw = "";
    assertThrows(NormalizedStringEmptyInputException.class, () -> new NormalizedString(raw));
  }

  @Test
  void shouldThrowExceptionWhenInputIsOnlySpaces() {
    String raw = "     ";
    assertThrows(NormalizedStringEmptyInputException.class, () -> new NormalizedString(raw));
  }

  @Test
  void shouldNormalizeSingleCharacter() {
    NormalizedString normalized = new NormalizedString("   A   ");
    assertEquals("a", normalized.toString());
  }

  @Test
  void shouldNormalizeMixedCaseSentence() {
    NormalizedString normalized = new NormalizedString("ThIs Is A TeSt");
    assertEquals("this is a test", normalized.toString());
  }
}
