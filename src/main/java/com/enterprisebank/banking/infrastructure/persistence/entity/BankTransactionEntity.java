package com.enterprisebank.banking.infrastructure.persistence.entity;

import com.enterprisebank.banking.domain.model.TransactionStatus;
import com.enterprisebank.banking.domain.model.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class BankTransactionEntity {
    @Id
    private UUID id;
    private UUID sourceAccountId;
    private UUID targetAccountId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;
    private String description;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private Instant createdAt;
}
