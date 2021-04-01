package com.adote.me.dtl.disease;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiseaseInputDTO {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

}
