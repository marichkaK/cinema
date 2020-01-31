package com.websystique.springboot.messaging.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketDto {

    private Long ticketId;
    private UserDto user;
    private MovieSessionPlaceDataKafkaDto movieSessionPlaceDataKafkaDto;
}
