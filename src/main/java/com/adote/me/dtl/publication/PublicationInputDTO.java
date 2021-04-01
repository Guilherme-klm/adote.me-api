package com.adote.me.dtl.publication;

import com.adote.me.dtl.animal.AnimalInputDTO;
import com.adote.me.model.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class PublicationInputDTO {

    @JsonProperty("description")
    @NotEmpty
    private String description;

    @JsonProperty("imagesBase64")
    private List<String> imagesBase64;

    @JsonProperty("state")
    @NotEmpty
    private String state;

    @JsonProperty("city")
    @NotEmpty
    private String city;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("comments")
    @Valid
    private List<Comment> comments;

    @JsonProperty("user")
    @Valid
    private PublicationUserInputDTO publicationUserInputDTO;

    @JsonProperty("animal")
    @Valid
    private AnimalInputDTO animalInputDTO;


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

    public List<Comment> getComments() {
        return comments;
    }

    public PublicationUserInputDTO getPublicationUserInputDTO() {
        return publicationUserInputDTO;
    }

    public AnimalInputDTO getAnimalInputDTO() {
        return animalInputDTO;
    }

}
