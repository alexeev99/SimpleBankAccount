package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.exceptions.BankIdInvalidStringException;
import java.util.UUID;

public class BankId {

  private final UUID bankId;

  public BankId() {
    this.bankId = UUID.randomUUID();
  }

  public BankId(String bankId) throws BankIdInvalidStringException {
    this.bankId = transformStringToUuid(bankId);
  }

  private static UUID transformStringToUuid(String bankId) throws BankIdInvalidStringException {
    UUID bankIdUuid;
    try {
      bankIdUuid = UUID.fromString(bankId);
    } catch (IllegalArgumentException e) {
      throw new BankIdInvalidStringException(bankId);
    }
    return bankIdUuid;
  }

  @Override
  public String toString() {
    return this.bankId.toString();
  }
}
