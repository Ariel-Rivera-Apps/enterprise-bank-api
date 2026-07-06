package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.infrastructure.persistence.entity.BankTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface JpaBankTransactionRepository extends JpaRepository<BankTransactionEntity, UUID> {
    Page<BankTransactionEntity> findBySourceAccountIdOrTargetAccountId(UUID sourceAccountId, UUID targetAccountId, Pageable pageable);
}
