package com.enterprisebank.banking.infrastructure.persistence.entity;

import com.enterprisebank.banking.domain.model.CustomerStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String documentNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CustomerStatus status;
    @Column(nullable = false)
    private Instant createdAt;
    @Column(nullable = false)
    private Instant updatedAt;
}
