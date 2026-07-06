package com.enterprisebank.banking.infrastructure.persistence.repository;

import com.enterprisebank.banking.domain.model.User;
import com.enterprisebank.banking.domain.repository.UserRepository;
import com.enterprisebank.banking.infrastructure.persistence.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
class UserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository repository;
    private final PersistenceMapper mapper;

    public User save(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(mapper::toDomain);
    }

    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    public boolean existsByUsernameOrEmail(String username, String email) {
        return repository.existsByUsernameOrEmail(username, email);
    }
}
