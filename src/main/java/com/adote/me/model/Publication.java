package com.adote.me.model;

import com.adote.me.dtl.animal.AnimalInputDTO;
import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.dtl.publication.PublicationUserInputDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection = "publication")
public class Publication {

    @Id
    private ObjectId id;

    @Field("description")
    private String description;

    @Field("imagePathName")
    private String imagePathName;

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

    public Publication(ObjectId id, String description, String imagePathName, String state, String city, String neighborhood, String creationTimeDate, PublicationUser publicationUser, Animal animal) {
        this.id = id;
        this.description = description;
        this.imagePathName = imagePathName;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.creationTimeDate = creationTimeDate;
        this.publicationUser = new PublicationUser();
        this.animal = new Animal();
    }

    public Publication publicationBuilder(PublicationInputDTO inputDTO, String imagePathName) {
        return builder()
                .withId(inputDTO.getId())
                .withDescription(inputDTO.getDescription())
                .withImagePathName(imagePathName)
                .withState(inputDTO.getState())
                .withCity(inputDTO.getCity())
                .withNeighborhood(inputDTO.getNeighborhood())
                .withCreationTimeDate(getCurrentDateTime())
                .withPublicationUser(inputDTO.getPublicationUserInputDTO())
                .withAnimal(inputDTO.getAnimalInputDTO())
                .build();
    }

    public Publication() {}

    public ObjectId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePathName() {
        return imagePathName;
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

    private String getCurrentDateTime() {
        var dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        var date = new Date();
        return dateFormat.format(date);
    }

    public static Builder builder() {
        return new Publication().new Builder();
    }

    public class Builder {

        private Publication publication;

        Builder() {
            this.publication = new Publication();
        }

        public Publication build() {
            return publication;
        }

        public Builder withId(ObjectId id) {
            publication.id = id;
            return this;
        }

        public Builder withDescription(String description) {
            publication.description = description;
            return this;
        }

        public Builder withImagePathName(String imagePathName) {
            publication.imagePathName = imagePathName;
            return this;
        }

        public Builder withState(String state) {
            publication.state = state;
            return this;
        }

        public Builder withCity(String city) {
            publication.city = city;
            return this;
        }

        public Builder withNeighborhood(String neighborhood) {
            publication.neighborhood = neighborhood;
            return this;
        }

        public Builder withCreationTimeDate(String creationTimeDate) {
            publication.creationTimeDate = creationTimeDate;
            return this;
        }

        public Builder withPublicationUser(PublicationUserInputDTO user) {
            publication.publicationUser = new PublicationUser(user);
            return this;
        }

        public Builder withAnimal(AnimalInputDTO animal) {
            publication.animal = new Animal(animal);
            return this;
        }
    }
}
