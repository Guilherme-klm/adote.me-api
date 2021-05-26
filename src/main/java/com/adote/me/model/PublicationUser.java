package com.adote.me.model;

import com.adote.me.dtl.publication.PublicationUserInputDTO;
import org.springframework.data.mongodb.core.mapping.Field;

public class PublicationUser {

    @Field("id")
    private Long id;

    @Field("name")
    private String name;

    public PublicationUser() {}

    public PublicationUser(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublicationUser(PublicationUserInputDTO inputDTO) {
        this.id = inputDTO.getId();
        this.name = inputDTO.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
