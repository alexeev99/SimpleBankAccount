package com.mycompany.app.customer.valueobjects;

import java.util.UUID;

public class CustomerId {

    private final UUID customerId;

    public CustomerId() {
        this.customerId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return this.customerId.toString();
    }
}
