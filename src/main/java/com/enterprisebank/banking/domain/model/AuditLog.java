package com.enterprisebank.banking.domain.model;

import java.time.Instant;
import java.util.UUID;

public record AuditLog(UUID id, String username, String httpMethod, String endpoint, String operation, int statusCode, Instant createdAt) {
}
