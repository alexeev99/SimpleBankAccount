package com.mycompany.app.bankaccount.exceptions;

public class BankAccountManagerCouldNotFindAccountException extends RuntimeException {

  public BankAccountManagerCouldNotFindAccountException(String bankId) {
    super(String.format("A bank account with the bank ID: '%s' could not be found.", bankId));
  }
}
