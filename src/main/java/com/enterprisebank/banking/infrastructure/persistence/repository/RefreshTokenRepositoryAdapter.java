package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.domain.model.RefreshToken;
import com.enterprisebank.banking.domain.repository.RefreshTokenRepository;
import com.enterprisebank.banking.infrastructure.persistence.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class RefreshTokenRepositoryAdapter implements RefreshTokenRepository {
    private final JpaRefreshTokenRepository repository;
    private final PersistenceMapper mapper;

    public RefreshToken save(RefreshToken token) {
        return mapper.toDomain(repository.save(mapper.toEntity(token)));
    }

    public Optional<RefreshToken> findByTokenHash(String tokenHash) {
        return repository.findByTokenHash(tokenHash).map(mapper::toDomain);
    }

    public void revoke(String tokenHash) {
        repository.findByTokenHash(tokenHash).ifPresent(entity -> {
            entity.setRevoked(true);
            repository.save(entity);
        });
    }
}
