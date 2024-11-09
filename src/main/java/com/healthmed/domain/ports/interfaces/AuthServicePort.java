package com.healthmed.domain.ports.interfaces;

import com.healthmed.domain.User;
import com.healthmed.domain.dtos.AuthDTO;
import com.healthmed.domain.dtos.patient.UserDto;

public interface AuthServicePort {
    AuthDTO login(String email, String password);
    void registerUser(UserDto userDto);
}

