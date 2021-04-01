package com.adote.me.dtl.animal;

import com.adote.me.dtl.disease.DiseaseOutputDTO;
import com.adote.me.dtl.remedy.RemedyOutputDTO;
import com.adote.me.dtl.vaccine.VaccineOutputDTO;

public class AnimalOutputDTO {

    private String name;

    private String breed;

    private VaccineOutputDTO vaccineOutputDTO;

    private RemedyOutputDTO remedyOutputDTO;

    private DiseaseOutputDTO diseaseOutputDTO;

    public AnimalOutputDTO(String name, String breed, VaccineOutputDTO vaccineOutputDTO, RemedyOutputDTO remedyOutputDTO, DiseaseOutputDTO diseaseOutputDTO) {
        this.name = name;
        this.breed = breed;
        this.vaccineOutputDTO = vaccineOutputDTO;
        this.remedyOutputDTO = remedyOutputDTO;
        this.diseaseOutputDTO = diseaseOutputDTO;
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
