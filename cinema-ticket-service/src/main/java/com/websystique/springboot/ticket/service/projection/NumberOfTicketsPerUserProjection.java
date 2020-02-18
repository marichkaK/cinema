package com.websystique.springboot.ticket.service.projection;

import com.websystique.springboot.ticket.service.dto.NumberOfTicketsPerUserDto;
import com.websystique.springboot.ticket.service.model.User;
import lombok.Data;

@Data
public class NumberOfTicketsPerUserProjection {

    private User user;
    private Integer numberOfTickets;

    public NumberOfTicketsPerUserDto toDto() {
        return NumberOfTicketsPerUserDto.builder()
                .userId(user.getUserId())
                .numberOfTickets(numberOfTickets)
                .build();
    }
}
