package com.adote.me.dtl.publication;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class PublicationUserInputDTO {

    @NotNull
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
