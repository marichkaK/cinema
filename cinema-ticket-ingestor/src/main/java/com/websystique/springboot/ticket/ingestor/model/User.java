package com.websystique.springboot.ticket.ingestor.model;

import com.websystique.springboot.messaging.common.UserDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document
public class User {

    @Id
    private String id;

    @Field
    private Long userId;

    @Field
    private Integer age;

    public static User toUser(UserDto userDto) {
        return new User(null, userDto.getId(), userDto.getAge());
    }
}
