package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.exceptions.BankIdInvalidStringException;

import java.util.UUID;

/**
 * Represents the unique identifier for a bank account. <br>
 * <br>
 * A {@code BankId} wraps a {@link UUID} to ensure uniqueness and domain-specific semantics for
 * identifying bank accounts.
 *
 * <p>Instances can either be randomly generated or constructed from a string representation of a
 * UUID.
 */
public class BankId {

  private final UUID bankId;

  /** Creates a new {@code BankId} with a randomly generated UUID. */
  public BankId() {
    this.bankId = UUID.randomUUID();
  }

  /**
   * Creates a new {@code BankId} from a string representation of a UUID.
   *
   * @param bankId the string representation of the bank ID
   * @throws BankIdInvalidStringException if the provided string is not a valid UUID
   */
  public BankId(String bankId) throws BankIdInvalidStringException {
    this.bankId = transformStringToUuid(bankId);
  }

  /**
   * Transforms a string into a {@link UUID}.
   *
   * @param bankId the string representation of the UUID
   * @return the parsed UUID
   * @throws BankIdInvalidStringException if the string is not a valid UUID
   */
  private static UUID transformStringToUuid(String bankId) throws BankIdInvalidStringException {
    try {
      return UUID.fromString(bankId);
    } catch (IllegalArgumentException e) {
      throw new BankIdInvalidStringException(bankId);
    }
  }

  /**
   * Returns the string representation of the bank ID.
   *
   * @return the UUID as a string
   */
  @Override
  public String toString() {
    return this.bankId.toString();
  }
}
