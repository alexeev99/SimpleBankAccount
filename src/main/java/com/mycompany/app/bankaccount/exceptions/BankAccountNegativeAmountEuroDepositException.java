package com.mycompany.app.bankaccount.exceptions;

public class BankAccountNegativeAmountEuroDepositException extends RuntimeException {

  public BankAccountNegativeAmountEuroDepositException(double amountEuro) {
    super(String.format("A negative amount %.2f cannot be deposit.", amountEuro));
  }
}
