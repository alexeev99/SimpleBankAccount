package com.mycompany.app.unit.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mycompany.app.customer.valueobjects.CustomerId;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CustomerIdTest {

  @Test
  void shouldGenerateUuidWhenUsingConstructorWithoutArguments() {
    String testUuidString = "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa";
    UUID testUuid = UUID.fromString(testUuidString);

    try (MockedStatic<UUID> mockedUuidClass = Mockito.mockStatic(UUID.class)) {
      mockedUuidClass.when(UUID::randomUUID).thenReturn(testUuid);

      CustomerId customerId = new CustomerId();

      assertEquals(testUuidString, customerId.toString());
      mockedUuidClass.verify(UUID::randomUUID);
    }
  }

  @Test
  void shouldProduceValidUuidFormat() {
    CustomerId customerId = new CustomerId();
    UUID parsed = UUID.fromString(customerId.toString());

    assertEquals(customerId.toString(), parsed.toString());
  }
}
