package com.adote.me.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class PublicationUser {

    @Id
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
