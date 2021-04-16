package com.adote.me.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {

    @Id
    private String id;

    @Field("description")
    private String description;

    @Field("creationTimeDate")
    private String creationTimeDate;

    @Field("changeTimeDate")
    private String changeTimeDate;

    @Field("commentUser")
    private CommentUser commentUser;

    public Comment(String description, CommentUser commentUser) {
        this.description = description;
        this.commentUser = commentUser;
    }

    public Comment() {}

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCreationTimeDate() {
        return getCurrentDateTime();
    }

    public String getChangeTimeDate() {
        return getCurrentDateTime();
    }

    public CommentUser getCommentUser() {
        return commentUser;
    }

    public String getCurrentDateTime() {
        var dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        var date = new Date();
        return dateFormat.format(date);
    }
}
