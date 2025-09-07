package com.mycompany.app.bankaccount.valueobjects;

import java.util.UUID;

/**
 * Represents the unique identifier of a transaction. <br>
 * <br>
 * A {@code TransactionId} wraps a {@link UUID} to provide domain-specific semantics for identifying
 * transactions.
 */
public class TransactionId {

  private final UUID transactionId;

  /** Creates a new {@code TransactionId} with a randomly generated UUID. */
  public TransactionId() {
    this.transactionId = UUID.randomUUID();
  }

  /**
   * Returns the string representation of the transaction ID.
   *
   * @return the transaction ID as a string
   */
  @Override
  public String toString() {
    return this.transactionId.toString();
  }
}
