package com.enterprisebank.banking.domain.repository;

import com.enterprisebank.banking.domain.model.AuditLog;

public interface AuditLogRepository {
    AuditLog save(AuditLog auditLog);
}
