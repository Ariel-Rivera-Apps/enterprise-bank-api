package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.domain.model.AuditLog;
import com.enterprisebank.banking.domain.repository.AuditLogRepository;
import com.enterprisebank.banking.infrastructure.persistence.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class AuditLogRepositoryAdapter implements AuditLogRepository {
    private final JpaAuditLogRepository repository;
    private final PersistenceMapper mapper;

    public AuditLog save(AuditLog auditLog) {
        return mapper.toDomain(repository.save(mapper.toEntity(auditLog)));
    }
}
