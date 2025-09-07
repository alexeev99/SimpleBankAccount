package com.mycompany.app.bankaccount.valueobjects;

import com.mycompany.app.bankaccount.enums.Operation;
import java.time.LocalDateTime;

/**
 * Represents a transaction performed on a bank account. <br>
 * <br>
 * A {@code Transaction} captures the timestamp, unique transaction ID, type of operation, and the
 * involved bank accounts (sender and target).
 *
 * <p>This class is implemented as a {@link java.lang.Record}, making it immutable and concise.
 *
 * @param timestamp the date and time when the transaction occurred
 * @param transactionId the unique identifier for the transaction
 * @param operation the type of operation performed (deposit, withdraw, transfer)
 * @param senderBankId the originating bank account ID (may be {@code null} for deposits)
 * @param targetBankId the receiving bank account ID (may be {@code null} for withdrawals)
 */
public record Transaction(
    LocalDateTime timestamp,
    TransactionId transactionId,
    Operation operation,
    BankId senderBankId,
    BankId targetBankId) {}
