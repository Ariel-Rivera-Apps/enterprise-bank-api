package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.domain.model.BankTransaction;
import com.enterprisebank.banking.domain.repository.BankTransactionRepository;
import com.enterprisebank.banking.infrastructure.persistence.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
class BankTransactionRepositoryAdapter implements BankTransactionRepository {
    private final JpaBankTransactionRepository repository;
    private final PersistenceMapper mapper;

    public BankTransaction save(BankTransaction transaction) {
        return mapper.toDomain(repository.save(mapper.toEntity(transaction)));
    }

    public Page<BankTransaction> findHistory(UUID accountId, Pageable pageable) {
        return repository.findBySourceAccountIdOrTargetAccountId(accountId, accountId, pageable).map(mapper::toDomain);
    }
}
