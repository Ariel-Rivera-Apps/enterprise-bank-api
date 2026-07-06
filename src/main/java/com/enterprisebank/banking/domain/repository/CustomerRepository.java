package com.enterprisebank.banking.domain.repository;

import com.enterprisebank.banking.domain.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
    Page<Customer> search(String query, Pageable pageable);
    boolean existsByEmailOrDocumentNumber(String email, String documentNumber);
    void deleteById(UUID id);
}
