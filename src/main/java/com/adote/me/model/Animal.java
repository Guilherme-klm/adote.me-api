package com.adote.me.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Animal {

    @Field("name")
    private String name;

    @Field("breed")
    private String breed;

    @Field("vaccineInputDTO")
    private Vaccine vaccine;

    @Field("remedyInputDTO")
    private Remedy remedy;

    @Field("diseaseInputDTO")
    private Disease disease;

    public Animal(String name, String breed, Vaccine vaccine, Remedy remedy, Disease disease) {
        this.name = name;
        this.breed = breed;
        this.vaccine = vaccine;
        this.remedy = remedy;
        this.disease = disease;
    }

    public Animal() {}

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public Remedy getRemedy() {
        return remedy;
    }

    public Disease getDisease() {
        return disease;
    }
}
