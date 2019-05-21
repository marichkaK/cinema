package com.websystique.springboot.api.model;

import com.websystique.springboot.messaging.common.UserDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity(name = "User")
@Table(name = "user")
public class User {

    public static final String CURRENT_USER = "current_user_attribute";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "age", nullable = false)
    private Integer age;

    public UserDto toKafkaDto() {
        return UserDto.builder()
            .id(id)
            .age(age)
            .build();
    }
}
