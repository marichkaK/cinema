package com.websystique.springboot.api.model;

public enum Status {
    FREE("free"), BOOKED("booked");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
