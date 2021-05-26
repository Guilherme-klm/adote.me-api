package com.adote.me.dtl.vaccine;

import com.adote.me.model.Vaccine;

public class VaccineOutputDTO {

    private String name;

    private String date;

    private String validity;

    public VaccineOutputDTO(Vaccine vaccine) {
        this.name = vaccine.getName();
        this.date = vaccine.getDate();
        this.validity = vaccine.getValidity();
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
