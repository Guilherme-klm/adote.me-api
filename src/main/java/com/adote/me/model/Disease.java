package com.adote.me.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Disease {

    @Field("name")
    private String name;

    public Disease(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
