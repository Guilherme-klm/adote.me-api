package com.adote.me.dtl.publication;

import com.adote.me.model.PublicationUser;

public class PublicationUserOutputDTO {

    private Long id;

    private String name;

    public PublicationUserOutputDTO(PublicationUser user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
