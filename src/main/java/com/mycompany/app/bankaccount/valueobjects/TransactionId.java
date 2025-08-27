package com.mycompany.app.bankaccount.valueobjects;

import java.util.UUID;

public class TransactionId {

  private final UUID transactionId;

  public TransactionId() {
    this.transactionId = UUID.randomUUID();
  }

  @Override
  public String toString() {
    return this.transactionId.toString();
  }
}
