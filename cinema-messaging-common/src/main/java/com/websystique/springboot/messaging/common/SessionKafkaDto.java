package com.websystique.springboot.messaging.common;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionKafkaDto {
    private Long id;
    private MovieKafkaDto movieKafkaDto;
}
