package com.enterprisebank.banking.domain.repository;

import com.enterprisebank.banking.domain.model.BankAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface BankAccountRepository {
    BankAccount save(BankAccount account);
    Optional<BankAccount> findById(UUID id);
    Optional<BankAccount> findByIdForUpdate(UUID id);
    Page<BankAccount> findByCustomerId(UUID customerId, Pageable pageable);
}
