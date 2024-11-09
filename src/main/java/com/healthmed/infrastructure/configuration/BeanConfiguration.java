package com.healthmed.infrastructure.configuration;

import com.healthmed.domain.adapters.services.AuthServiceImp;
import com.healthmed.cognito.CognitoClient;
import com.healthmed.domain.ports.interfaces.AuthServicePort;
import com.healthmed.domain.ports.repositories.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    AuthServicePort authServicePort(CognitoClient cognitoClient, UserRepositoryPort repositoryPort) {
        return new AuthServiceImp(cognitoClient, repositoryPort);
    }

}
