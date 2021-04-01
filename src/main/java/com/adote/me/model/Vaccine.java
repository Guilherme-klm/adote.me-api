package com.adote.me.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Vaccine implements BaseHealth {

    @Field("name")
    private String name;

    @Field("date")
    private String date;

    @Field("validity")
    private String validity;

    public Vaccine(String name, String date, String validity) {
        this.name = name;
        this.date = date;
        this.validity = validity;
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
