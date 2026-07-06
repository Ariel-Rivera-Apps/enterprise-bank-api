package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.domain.model.BankAccount;
import com.enterprisebank.banking.domain.repository.BankAccountRepository;
import com.enterprisebank.banking.infrastructure.persistence.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class BankAccountRepositoryAdapter implements BankAccountRepository {
    private final JpaBankAccountRepository repository;
    private final PersistenceMapper mapper;

    public BankAccount save(BankAccount account) {
        return mapper.toDomain(repository.save(mapper.toEntity(account)));
    }

    public Optional<BankAccount> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Optional<BankAccount> findByIdForUpdate(UUID id) {
        return repository.findByIdForUpdate(id).map(mapper::toDomain);
    }

    public Page<BankAccount> findByCustomerId(UUID customerId, Pageable pageable) {
        return repository.findByCustomerId(customerId, pageable).map(mapper::toDomain);
    }
}
