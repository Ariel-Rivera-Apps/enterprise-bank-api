package com.enterprisebank.banking.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "audit_logs")
public class AuditLogEntity {
    @Id
    private UUID id;
    private String username;
    @Column(nullable = false)
    private String httpMethod;
    @Column(nullable = false)
    private String endpoint;
    @Column(nullable = false)
    private String operation;
    @Column(nullable = false)
    private int statusCode;
    @Column(nullable = false)
    private Instant createdAt;
}
