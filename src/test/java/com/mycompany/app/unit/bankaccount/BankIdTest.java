package com.mycompany.app.unit.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.mycompany.app.bankaccount.exceptions.BankIdInvalidStringException;
import com.mycompany.app.bankaccount.valueobjects.BankId;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class BankIdTest {
  @Test
  void shouldGenerateUuidWhenUsingConstructorWithoutArguments() {
    String testUuidString = "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa";
    UUID testUuid = UUID.fromString(testUuidString);

    try (MockedStatic<UUID> mockedUuidClass = Mockito.mockStatic(UUID.class)) {
      mockedUuidClass.when(UUID::randomUUID).thenReturn(testUuid);

      BankId bankId = new BankId();

      assertEquals(testUuidString, bankId.toString());
      mockedUuidClass.verify(UUID::randomUUID);
    }
  }

  @Test
  void shouldTransformStringToUuidWhenUsingConstructorWithValidArguments() {
    String testUuidString = "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa";

    BankId bankId = new BankId(testUuidString);

    assertEquals(testUuidString, bankId.toString());
  }

  @Test
  void shouldThrowBankIdInvalidStringExceptionWhenUsingConstructorWithInvalidArguments() {
    String testUuidString = "invalid uuid";
    String errorMessage =
        String.format(
            "Following bank ID: '%s' is invalid and could not be transformed to an UUID.",
            testUuidString);

    Executable newBankIdExecutable = () -> new BankId(testUuidString);

    BankIdInvalidStringException bankIdInvalidStringException =
        assertThrows(BankIdInvalidStringException.class, newBankIdExecutable);

    assertEquals(errorMessage, bankIdInvalidStringException.getMessage());
  }
}
