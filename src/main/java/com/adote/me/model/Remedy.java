package com.adote.me.model;

import com.adote.me.dtl.remedy.RemedyInputDTO;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "publication")
public class Remedy implements BaseHealth {

    @Field("name")
    private String name;

    @Field("date")
    private String date;

    @Field("validity")
    private String validity;

    public Remedy() {}

    public Remedy(String name, String date, String validity) {
        this.name = name;
        this.date = date;
        this.validity = validity;
    }

    public Remedy(RemedyInputDTO inputDTO) {
        this.name = inputDTO.getName();
        this.date = inputDTO.getDate();
        this.validity = inputDTO.getValidity();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getValidity() {
        return validity;
    }
}
