package com.websystique.springboot.messaging.common;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieKafkaDto {
    private String name;
    private Integer duration;
    private Integer minAge;
    private String country;
}
