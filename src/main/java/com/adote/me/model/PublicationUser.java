package com.adote.me.model;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class PublicationUser {

    @MongoId
    @Field("id")
    private Long id;

    @Field("name")
    private String name;

    public PublicationUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
