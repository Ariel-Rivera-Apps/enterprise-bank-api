package com.enterprisebank.banking.domain.repository;

import com.enterprisebank.banking.domain.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    RefreshToken save(RefreshToken token);
    Optional<RefreshToken> findByTokenHash(String tokenHash);
    void revoke(String tokenHash);
}
