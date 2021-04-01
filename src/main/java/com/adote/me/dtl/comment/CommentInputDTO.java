package com.adote.me.dtl.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class CommentInputDTO {

    @JsonProperty("id")
    @NotEmpty
    private Long id;

    @JsonProperty("description")
    @NotEmpty
    private String description;

    @JsonProperty("commentUser")
    @Valid
    private CommentUserInputDTO commentUserInputDTO;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public CommentUserInputDTO getCommentUserInputDTO() {
        return commentUserInputDTO;
    }
}
