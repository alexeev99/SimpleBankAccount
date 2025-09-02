package com.mycompany.app.bankaccount.exceptions;

public class BankIdInvalidStringException extends RuntimeException {

  public BankIdInvalidStringException(String bankId) {
    super(
        String.format(
            "Following bank ID: '%s' is invalid and could not be transformed to an UUID.", bankId));
  }
}
