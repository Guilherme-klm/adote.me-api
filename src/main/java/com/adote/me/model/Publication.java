package com.adote.me.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "publication")
public class Publication {

    @Id
    private ObjectId id;

    @Field("description")
    private String description;

    @Field("imagesBase64")
    private String imagesBase64;

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

    public Publication(ObjectId id, String description, String imagesBase64, String state, String city, String neighborhood, String creationTimeDate, PublicationUser publicationUser, Animal animal) {
        this.id = id;
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

    public ObjectId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImagesBase64() {
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
