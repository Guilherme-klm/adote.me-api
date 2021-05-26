package com.adote.me.dtl.remedy;

import com.adote.me.model.Remedy;

public class RemedyOutputDTO {

    private String name;

    private String date;

    private String validity;

    public RemedyOutputDTO(Remedy remedy) {
        this.name = remedy.getName();
        this.date = remedy.getDate();
        this.validity = remedy.getValidity();
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
