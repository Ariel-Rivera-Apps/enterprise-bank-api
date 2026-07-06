package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.domain.model.Customer;
import com.enterprisebank.banking.domain.repository.CustomerRepository;
import com.enterprisebank.banking.infrastructure.persistence.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class CustomerRepositoryAdapter implements CustomerRepository {
    private final JpaCustomerRepository repository;
    private final PersistenceMapper mapper;

    public Customer save(Customer customer) {
        return mapper.toDomain(repository.save(mapper.toEntity(customer)));
    }

    public Optional<Customer> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public Page<Customer> search(String query, Pageable pageable) {
        if (query == null || query.isBlank()) {
            return repository.findAll(pageable).map(mapper::toDomain);
        }
        return repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                query, query, query, pageable).map(mapper::toDomain);
    }

    public boolean existsByEmailOrDocumentNumber(String email, String documentNumber) {
        return repository.existsByEmailOrDocumentNumber(email, documentNumber);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
