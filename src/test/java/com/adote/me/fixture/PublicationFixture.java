package com.adote.me.fixture;

import com.google.gson.Gson;

public class PublicationFixture {

    private String description;
    private String state;
    private String city;
    private String neighborhood;
    private PublicationUserFixture user;
    private AnimalFixture animal;

    public PublicationFixture withDescription(String description) {
        this.description = description;
        return this;
    }

    public PublicationFixture withState(String state) {
        this.state = state;
        return this;
    }

    public PublicationFixture withCity(String city) {
        this.city = city;
        return this;
    }

    public PublicationFixture withNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public PublicationFixture withPublicationUser(PublicationUserFixture fixture) {
        this.user = new PublicationUserFixture(fixture);
        return this;
    }

    public PublicationFixture withAnimal(AnimalFixture fixture) {
        this.animal = new AnimalFixture(fixture);
        return this;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }
}
