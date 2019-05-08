package com.websystique.springboot.ui.dto;

import java.util.Date;
import lombok.Data;

@Data
public class MovieDto {

    private String name;
    private Date startDate;
    private Integer numOfTickets;
}
