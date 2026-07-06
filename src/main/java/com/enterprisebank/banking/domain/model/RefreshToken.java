package com.enterprisebank.banking.domain.model;

import java.time.Instant;
import java.util.UUID;

public record RefreshToken(UUID id, UUID userId, String tokenHash, Instant expiresAt, boolean revoked, Instant createdAt) {
    public boolean isValid(Instant now) {
        return !revoked && expiresAt.isAfter(now);
    }
}
