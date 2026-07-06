package com.enterprisebank.banking.domain.model;

import java.time.Instant;
import java.util.UUID;

public record User(UUID id, String username, String email, String passwordHash, Role role, boolean enabled, Instant createdAt) {
}
