package com.mycompany.app.bankaccount.exceptions;

/** Thrown when a bank account cannot be found for a given bank ID. */
public class BankAccountManagerCouldNotFindAccountException extends RuntimeException {

  /**
   * Constructs a new exception with a message indicating the missing bank account ID.
   *
   * @param bankId the bank ID that could not be found
   */
  public BankAccountManagerCouldNotFindAccountException(String bankId) {
    super(String.format("A bank account with the bank ID: '%s' could not be found.", bankId));
  }
}
