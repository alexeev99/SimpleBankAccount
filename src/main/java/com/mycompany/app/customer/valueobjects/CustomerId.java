package com.mycompany.app.customer.valueobjects;

import java.util.UUID;

/**
 * Represents the unique identifier for a customer. <br>
 * <br>
 * A {@code CustomerId} wraps a {@link UUID} to enforce uniqueness and provide domain-specific
 * semantics.
 */
public class CustomerId {

  private final UUID customerId;

  /** Creates a new {@code CustomerId} with a randomly generated UUID. */
  public CustomerId() {
    this.customerId = UUID.randomUUID();
  }

  /**
   * Returns the string representation of the customer ID.
   *
   * @return the customer ID as a string
   */
  @Override
  public String toString() {
    return this.customerId.toString();
  }
}
