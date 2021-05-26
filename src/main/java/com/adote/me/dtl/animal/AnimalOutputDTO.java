package com.adote.me.dtl.animal;

import com.adote.me.dtl.disease.DiseaseOutputDTO;
import com.adote.me.dtl.remedy.RemedyOutputDTO;
import com.adote.me.dtl.vaccine.VaccineOutputDTO;
import com.adote.me.model.Animal;

public class AnimalOutputDTO {

    private String name;

    private String breed;

    private VaccineOutputDTO vaccineOutputDTO;

    private RemedyOutputDTO remedyOutputDTO;

    private DiseaseOutputDTO diseaseOutputDTO;

    public AnimalOutputDTO(Animal animal) {
        this.name = animal.getName();
        this.breed = animal.getBreed();
        this.vaccineOutputDTO = new VaccineOutputDTO(animal.getVaccine());
        this.remedyOutputDTO = new RemedyOutputDTO(animal.getRemedy());
        this.diseaseOutputDTO = new DiseaseOutputDTO(animal.getDisease());
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public VaccineOutputDTO getVaccineOutputDTO() {
        return vaccineOutputDTO;
    }

    public RemedyOutputDTO getRemedyOutputDTO() {
        return remedyOutputDTO;
    }

    public DiseaseOutputDTO getDiseaseOutputDTO() {
        return diseaseOutputDTO;
    }
}
