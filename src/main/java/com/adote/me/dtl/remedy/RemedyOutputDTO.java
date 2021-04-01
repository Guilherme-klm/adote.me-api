package com.adote.me.dtl.remedy;

public class RemedyOutputDTO {

    private String name;

    private String date;

    private String validity;

    public RemedyOutputDTO(String name, String date, String validity) {
        this.name = name;
        this.date = date;
        this.validity = validity;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getValidity() {
        return validity;
    }
}
