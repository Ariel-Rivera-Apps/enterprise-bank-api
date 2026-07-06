package com.enterprisebank.banking.domain.repository;

import com.enterprisebank.banking.domain.model.BankTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BankTransactionRepository {
    BankTransaction save(BankTransaction transaction);
    Page<BankTransaction> findHistory(UUID accountId, Pageable pageable);
}
