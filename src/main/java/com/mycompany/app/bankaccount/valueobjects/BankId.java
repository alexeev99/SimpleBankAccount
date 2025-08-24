package com.mycompany.app.bankaccount.valueobjects;

import java.util.UUID;

public class BankId {

    private final UUID bankId;

    public BankId() {
        this.bankId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return this.bankId.toString();
    }
}
