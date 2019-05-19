package com.websystique.springboot.auth.server.dto;

import com.websystique.springboot.auth.server.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String name;
    private String email;
    private String password;
    private Integer age;

    public User toModel() {
        return User.builder()
            .name(name)
            .email(email)
            .password(password)
            .age(age)
            .build();
    }
}
