package com.enterprisebank.banking.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record BankTransaction(
        UUID id,
        UUID sourceAccountId,
        UUID targetAccountId,
        TransactionType type,
        BigDecimal amount,
        TransactionStatus status,
        String description,
        String createdBy,
        Instant createdAt
) {
}
