package com.adote.me.dtl.animal;

import com.adote.me.dtl.disease.DiseaseInputDTO;
import com.adote.me.dtl.remedy.RemedyInputDTO;
import com.adote.me.dtl.vaccine.VaccineInputDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class AnimalInputDTO {

    @NotEmpty(message = "Nome não pode ser vazio")
    private String name;

    @NotEmpty(message = "Raça não pode ser vazia")
    private String breed;

    private VaccineInputDTO vaccine;

    private RemedyInputDTO remedy;

    private DiseaseInputDTO disease;

    public void validateAnimal() throws Exception {
        validateName();
        validateBreed();
        vaccine.validateVaccine();
        remedy.validateRemedy();
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public VaccineInputDTO getVaccineInputDTO() {
        return vaccine;
    }

    public RemedyInputDTO getRemedyInputDTO() {
        return remedy;
    }

    public DiseaseInputDTO getDiseaseInputDTO() {
        return disease;
    }

    private void validateName() throws Exception {
        if (name.isEmpty()) {
            throw new Exception(getClass().getDeclaredField("name").getAnnotation(NotEmpty.class).message());
        }
    }

    private void validateBreed() throws Exception {
        if (breed.isEmpty()) {
            throw new Exception(getClass().getDeclaredField("breed").getAnnotation(NotEmpty.class).message());
        }
    }
}
