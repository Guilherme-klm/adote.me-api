package com.adote.me.dtl.vaccine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccineInputDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("date")
    private String date;

    @JsonProperty("validity")
    private String validity;

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
