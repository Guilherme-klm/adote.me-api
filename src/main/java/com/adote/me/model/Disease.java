package com.adote.me.model;

import com.adote.me.dtl.disease.DiseaseInputDTO;
import org.springframework.data.mongodb.core.mapping.Field;

public class Disease {

    @Field("name")
    private String name;

    public Disease() {}

    public Disease(String name) {
        this.name = name;
    }

    public Disease(DiseaseInputDTO inputDTO) {
        this.name = inputDTO.getName();
    }

    public String getName() {
        return name;
    }
}
