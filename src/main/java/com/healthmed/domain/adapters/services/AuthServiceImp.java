package com.healthmed.domain.adapters.services;

import com.amazonaws.services.cognitoidp.model.NotAuthorizedException;
import com.healthmed.application.adapters.controllers.exception.BadRequestException;
import com.healthmed.application.adapters.controllers.exception.InternalServerErrorException;
import com.healthmed.cognito.CognitoClient;
import com.healthmed.domain.User;
import com.healthmed.domain.dtos.AuthDTO;
import com.healthmed.domain.dtos.patient.UserDto;
import com.healthmed.domain.ports.interfaces.AuthServicePort;
import com.healthmed.domain.ports.repositories.UserRepositoryPort;

import java.util.Optional;

public class AuthServiceImp implements AuthServicePort {

    private final CognitoClient client;
    private final UserRepositoryPort repositoryPort;

    public AuthServiceImp(CognitoClient client, UserRepositoryPort repositoryPort) {
        this.client = client;
        this.repositoryPort = repositoryPort;
    }

    @Override
    public AuthDTO login(String email, String password) {
        try {
            return client.login(email, password);
        } catch (NotAuthorizedException exception) {
            throw new BadRequestException("login ou senha inválidos");
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
    }


    private void signUp(User user) {
        try{
            client.signUp(user);
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception.getMessage());
        }
    }

    @Override
    public void registerUser(UserDto userDto) {
        var user = new User(userDto);
        validate(user);
        signUp(user);
        this.repositoryPort.save(user);
    }

    private void validate(User user) {
        Optional<User> optionalPatient = this.repositoryPort.findByCpf(user.getCpf());
        optionalPatient.ifPresent(patientExists -> {throw new BadRequestException("CPF já cadastrado");});
    }


}
