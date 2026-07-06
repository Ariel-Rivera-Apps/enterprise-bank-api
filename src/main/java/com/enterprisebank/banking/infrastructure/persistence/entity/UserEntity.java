package com.enterprisebank.banking.infrastructure.persistence.entity;

import com.enterprisebank.banking.domain.model.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private boolean enabled;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
}
