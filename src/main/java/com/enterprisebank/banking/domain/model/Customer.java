package com.enterprisebank.banking.domain.model;

import java.time.Instant;
import java.util.UUID;

public record Customer(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String documentNumber,
        CustomerStatus status,
        Instant createdAt,
        Instant updatedAt
) {
}
