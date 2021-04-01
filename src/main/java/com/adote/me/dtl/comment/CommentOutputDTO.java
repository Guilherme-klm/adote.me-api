package com.adote.me.dtl.comment;

public class CommentOutputDTO {

    private Long id;

    private String description;

    private CommentUserOutputDTO commentUserOutputDTO;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public CommentUserOutputDTO getCommentUserOutputDTO() {
        return commentUserOutputDTO;
    }
}
