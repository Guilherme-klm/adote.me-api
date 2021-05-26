package com.adote.me.model;

import com.adote.me.dtl.animal.AnimalInputDTO;
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

    public Animal(AnimalInputDTO inputDTO) {
        this.name = inputDTO.getName();
        this.breed = inputDTO.getBreed();
        this.vaccine = new Vaccine(inputDTO.getVaccineInputDTO());
        this.remedy = new Remedy(inputDTO.getRemedyInputDTO());
        this.disease = new Disease(inputDTO.getDiseaseInputDTO());
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
