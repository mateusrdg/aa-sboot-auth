package com.healthmed.application.adapters.controllers;

import com.healthmed.domain.dtos.AuthDTO;
import com.healthmed.domain.dtos.patient.UserDto;
import com.healthmed.domain.ports.interfaces.AuthServicePort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/compradores")
public class AuthController {
    private final AuthServicePort service;
    public AuthController(AuthServicePort service) {
        this.service = service;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestParam String email, @RequestParam String password) {
        return service.login(email, password);
    }

    @PostMapping("/register")
    void registerDoctor(@RequestBody @Valid UserDto userDto) {
        service.registerUser(userDto);
    }
}
