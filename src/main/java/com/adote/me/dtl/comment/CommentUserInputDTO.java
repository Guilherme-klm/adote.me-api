package com.adote.me.dtl.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class CommentUserInputDTO {

    @JsonProperty("id")
    @NotEmpty
    private Long id;

    @JsonProperty("name")
    @NotEmpty
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
