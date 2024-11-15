package com.healthmed.domain.dtos.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotNull(message = "O campo 'nome' não pode ser nulo")
    @NotBlank(message = "O campo 'nome' não pode estar em branco")
    private String name;
    @NotNull(message = "O campo 'cpf' não pode ser nulo")
    @NotBlank(message = "O campo 'cpf' não pode estar em branco")
    private String cpf;

    @NotNull(message = "O campo 'email' não pode ser nulo")
    @NotBlank(message = "O campo 'email' não pode estar em branco")
    private String email;

    @NotNull(message = "O campo 'password' não pode ser nulo")
    @NotBlank(message = "O campo 'password' não pode estar em branco")
    private String password;

    public UserDto(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

}
