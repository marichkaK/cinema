package com.websystique.springboot.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {

    private String name;

    private Date startDate;

    public MovieDto(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }
}
