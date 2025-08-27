package com.mycompany.app.customer.valueobjects;

import java.time.LocalDate;

public record Customer(
    CustomerId customerId,
    NormalizedString firstName,
    NormalizedString lastName,
    NormalizedString cityOfBirth,
    LocalDate birthDate,
    Address address,
    TaxId taxId) {}
