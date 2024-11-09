package com.healthmed.infrastructure.adapters.repositories;

import com.healthmed.domain.User;
import com.healthmed.infrastructure.adapters.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @InjectMocks
    private UserRepository repository;

    @Mock
    private UserJpaRepository jpaRepository;

    @Test
    void testFindPatientByCpfFound() {
        String cpf = "cpf";
        UserEntity userEntity = new UserEntity();
        userEntity.setCpf(cpf);
        when(jpaRepository.findByCpf(cpf)).thenReturn(Optional.of(userEntity));

        Optional<User> result = repository.findByCpf(cpf);

        assertTrue(result.isPresent());
        assertEquals(cpf, result.get().getCpf());
        verify(jpaRepository, times(1)).findByCpf(cpf);
    }

    @Test
    void testFindPatientByCpfNotFound() {
        String cpf = "cpf";
        when(jpaRepository.findByCpf(cpf)).thenReturn(Optional.empty());

        Optional<User> result = repository.findByCpf(cpf);

        assertFalse(result.isPresent());
        verify(jpaRepository, times(1)).findByCpf(cpf);
    }

    @Test
    void testSavePatientSuccess() {
        User user = new User();

        repository.save(user);

        verify(jpaRepository, times(1)).save(any(UserEntity.class));
    }
}
