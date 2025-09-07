package com.mycompany.app.bankaccount.enums;

/**
 * Represents the types of operations that can be performed on a bank account. <br>
 * <br>
 * These operations are used to categorize and execute actions such as depositing, withdrawing, or
 * transferring money.
 */
public enum Operation {

  /** Represents a deposit operation, where money is added to the account. */
  DEPOSIT,

  /** Represents a withdrawal operation, where money is removed from the account. */
  WITHDRAW,

  /** Represents a transfer operation, where money is moved between accounts. */
  TRANSFER,
}
