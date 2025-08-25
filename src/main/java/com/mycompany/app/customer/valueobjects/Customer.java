package com.mycompany.app.customer;

import com.mycompany.app.customer.valueobjects.Address;
import com.mycompany.app.customer.valueobjects.CustomerId;

public record Customer(
    CustomerId customerId,
    String firstName,
    String lastName,
    Address address
) {}
