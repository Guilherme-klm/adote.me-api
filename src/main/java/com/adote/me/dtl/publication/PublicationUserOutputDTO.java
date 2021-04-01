package com.adote.me.dtl.publication;

public class PublicationUserOutputDTO {

    private Long id;

    private String name;

    public PublicationUserOutputDTO(Long id, String name) {
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
