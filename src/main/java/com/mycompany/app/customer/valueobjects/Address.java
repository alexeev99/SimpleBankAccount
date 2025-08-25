package com.mycompany.app.customer.valueobjects;

public record Address(
    String city,
    PostalCode postalCode,
    int streetNumber,
    String street
) {}
