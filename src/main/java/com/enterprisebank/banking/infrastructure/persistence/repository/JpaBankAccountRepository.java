package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.infrastructure.persistence.entity.BankAccountEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

interface JpaBankAccountRepository extends JpaRepository<BankAccountEntity, UUID> {
    Page<BankAccountEntity> findByCustomerId(UUID customerId, Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from BankAccountEntity a where a.id = :id")
    Optional<BankAccountEntity> findByIdForUpdate(UUID id);
}
