package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
    boolean existsByEmailOrDocumentNumber(String email, String documentNumber);
    Page<CustomerEntity> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstName, String lastName, String email, Pageable pageable);
}
