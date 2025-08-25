package com.mycompany.app.customer.valueobjects;

import java.time.LocalDateTime;

public record Customer(
    CustomerId customerId,
    String firstName,
    String lastName,
    String cityOfBirth,
    LocalDateTime birthDate,
    Address address,
    TaxId taxId
) {}
