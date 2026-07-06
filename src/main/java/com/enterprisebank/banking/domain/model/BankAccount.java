package com.enterprisebank.banking.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record BankAccount(
        UUID id,
        UUID customerId,
        String accountNumber,
        AccountType type,
        AccountStatus status,
        BigDecimal balance,
        Instant openedAt,
        Instant closedAt
) {
    public BankAccount credit(BigDecimal amount) {
        return new BankAccount(id, customerId, accountNumber, type, status, balance.add(amount), openedAt, closedAt);
    }

    public BankAccount debit(BigDecimal amount) {
        return new BankAccount(id, customerId, accountNumber, type, status, balance.subtract(amount), openedAt, closedAt);
    }

    public BankAccount close(Instant closedAt) {
        return new BankAccount(id, customerId, accountNumber, type, AccountStatus.CLOSED, balance, openedAt, closedAt);
    }
}
