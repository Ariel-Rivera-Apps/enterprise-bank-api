package com.enterprisebank.banking.domain.repository;

import com.enterprisebank.banking.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findById(UUID id);
    boolean existsByUsernameOrEmail(String username, String email);
}
