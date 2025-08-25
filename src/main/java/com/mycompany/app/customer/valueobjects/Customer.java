package com.mycompany.app.customer.valueobjects;

public record Customer(
    CustomerId customerId,
    String firstName,
    String lastName,
    Address address
) {}
