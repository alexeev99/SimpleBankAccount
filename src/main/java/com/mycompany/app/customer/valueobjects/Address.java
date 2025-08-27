package com.mycompany.app.customer.valueobjects;

public record Address(
    NormalizedString city,
    PostalCode postalCode,
    StreetNumber streetNumber,
    NormalizedString streetName) {}
