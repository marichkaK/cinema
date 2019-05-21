package com.websystique.springboot.common.kafka;

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

    private Long id;
    private Long userId;
    private Long movieSessionPlaceDataId;
}
