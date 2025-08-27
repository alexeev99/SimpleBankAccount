package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.enums.Operation;

import java.time.LocalDateTime;

public record Transaction(
    LocalDateTime timestamp,
    TransactionId transactionId,
    Operation operation,
    BankId senderBankId,
    BankId targetBankId) {}
