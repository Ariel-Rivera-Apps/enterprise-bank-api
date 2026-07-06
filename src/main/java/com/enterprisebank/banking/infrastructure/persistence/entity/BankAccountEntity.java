package com.enterprisebank.banking.infrastructure.persistence.entity;

import com.enterprisebank.banking.domain.model.AccountStatus;
import com.enterprisebank.banking.domain.model.AccountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private UUID customerId;
    @Column(nullable = false, unique = true)
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType type;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance;
    @Column(nullable = false)
    private Instant openedAt;
    private Instant closedAt;
}
