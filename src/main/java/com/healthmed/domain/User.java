package com.healthmed.domain;

import com.healthmed.domain.dtos.patient.UserDto;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public User() {
    }

    public User(Long id, String name, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.cpf = userDto.getCpf();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
    }

    public UserDto toDto() {
        return new UserDto(this.name, this.cpf, this.email);
    }

}
