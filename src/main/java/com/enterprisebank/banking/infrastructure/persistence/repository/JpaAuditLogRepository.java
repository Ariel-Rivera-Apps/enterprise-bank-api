package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.infrastructure.persistence.entity.AuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface JpaAuditLogRepository extends JpaRepository<AuditLogEntity, UUID> {
}
