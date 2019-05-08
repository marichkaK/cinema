package com.websystique.springboot.api.model;

public enum Format {
    TWO_D("2D"),
    THREE_D("3D");

    private String format;

    Format(String format) {
        this.format = format;
    }


}
