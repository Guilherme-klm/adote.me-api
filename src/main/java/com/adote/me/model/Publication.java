package com.adote.me.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "publication")
public class Publication {

    @MongoId
    @Field("id")
    private String id;

    @Field("description")
    private String description;

    @Field("imagesBase64")
    private List<String> imagesBase64;

    @Field("state")
    private String state;

    @Field("city")
    private String city;

    @Field("neighborhood")
    private String neighborhood;

    @Field("creationTimeDate")
    private String creationTimeDate;

    @Field("changeTimeDate")
    private String changeTimeDate;

    @Field(value = "comments", targetType = FieldType.ARRAY)
    private List<Comment> comments;

    @Field("userPublication")
    private PublicationUser publicationUser;

    @Field("animal")
    private Animal animal;

    public Publication(String description, List<String> imagesBase64, String state, String city, String neighborhood, String creationTimeDate, PublicationUser publicationUser, Animal animal) {
        this.description = description;
        this.imagesBase64 = imagesBase64;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.creationTimeDate = creationTimeDate;
        this.publicationUser = publicationUser;
        this.animal = animal;
    }

    public Publication () {}

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImagesBase64() {
        return imagesBase64;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCreationTimeDate() {
        return creationTimeDate;
    }

    public String getChangeTimeDate() {
        return changeTimeDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public PublicationUser getPublicationUser() {
        return publicationUser;
    }

    public Animal getAnimal() {
        return animal;
    }

}
