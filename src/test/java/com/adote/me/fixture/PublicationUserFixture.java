package com.adote.me.fixture;

public class PublicationUserFixture {

    private Long id;
    private String name;

    public PublicationUserFixture(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublicationUserFixture(PublicationUserFixture fixture) {
        this.id = fixture.getId();
        this.name = fixture.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
