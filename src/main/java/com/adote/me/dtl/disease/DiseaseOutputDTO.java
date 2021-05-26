package com.adote.me.dtl.disease;

import com.adote.me.model.Disease;

public class DiseaseOutputDTO {

    private String name;

    public DiseaseOutputDTO(Disease disease) {
        this.name = disease.getName();
    }

    public String getName() {
        return name;
    }

}
