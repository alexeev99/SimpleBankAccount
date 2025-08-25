package com.mycompany.app.bankaccount;

import com.mycompany.app.bankaccount.enums.Operation;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.TransactionId;
import java.time.LocalDateTime;

public record Transaction(
    LocalDateTime timestamp,
    TransactionId transactionId,
    Operation operation,
    BankId senderBankId,
    BankId targetBankId
) {}
