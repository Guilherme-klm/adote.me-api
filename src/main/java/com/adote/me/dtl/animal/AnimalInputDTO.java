package com.adote.me.dtl.animal;

import com.adote.me.dtl.disease.DiseaseInputDTO;
import com.adote.me.dtl.remedy.RemedyInputDTO;
import com.adote.me.dtl.vaccine.VaccineInputDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class AnimalInputDTO {

    @JsonProperty("name")
    @NotEmpty
    private String name;

    @JsonProperty("breed")
    @NotEmpty
    private String breed;

    @JsonProperty("vaccine")
    private VaccineInputDTO vaccineInputDTO;

    @JsonProperty("remedy")
    private RemedyInputDTO remedyInputDTO;

    @JsonProperty("disease")
    private DiseaseInputDTO diseaseInputDTO;


    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public VaccineInputDTO getVaccineInputDTO() {
        return vaccineInputDTO;
    }

    public RemedyInputDTO getRemedyInputDTO() {
        return remedyInputDTO;
    }

    public DiseaseInputDTO getDiseaseInputDTO() {
        return diseaseInputDTO;
    }
}
