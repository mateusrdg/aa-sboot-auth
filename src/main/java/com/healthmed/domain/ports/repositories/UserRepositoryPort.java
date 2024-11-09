package com.healthmed.domain.ports.repositories;

import com.healthmed.domain.User;

import java.util.Optional;

public interface UserRepositoryPort {
    Optional<User> findByCpf(String cpf);
    void save(User user);
}
