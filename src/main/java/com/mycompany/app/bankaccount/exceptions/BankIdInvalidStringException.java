package com.mycompany.app.bankaccount.exceptions;

/** Thrown when a given bank ID string cannot be parsed into a valid UUID. */
public class BankIdInvalidStringException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the invalid bank ID string.
   *
   * @param bankId the invalid bank ID string
   */
  public BankIdInvalidStringException(String bankId) {
    super(
        String.format(
            "Following bank ID: '%s' is invalid and could not be transformed to an UUID.", bankId));
  }
}
