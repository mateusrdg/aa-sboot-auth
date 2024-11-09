package com.healthmed.infrastructure.adapters.repositories;

import com.healthmed.domain.User;
import com.healthmed.domain.ports.repositories.UserRepositoryPort;
import com.healthmed.infrastructure.adapters.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository implements UserRepositoryPort {

    private final UserJpaRepository jpaRepository;

    public UserRepository(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<User> findByCpf(String cpf) {
        Optional<UserEntity> entity = jpaRepository.findByCpf(cpf);
        return entity.map(UserEntity::toDomain);
    }

    @Override
    public void save(User user) {
        jpaRepository.save(new UserEntity(user));
    }
}
