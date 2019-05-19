package com.websystique.springboot.api.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewSessionDto {

    private Date sessionTime;
    private Integer basePrice;
    private Integer priceForLastRow;
}
