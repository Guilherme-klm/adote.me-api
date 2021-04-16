package com.adote.me.dtl.publication;

import com.adote.me.dtl.animal.AnimalOutputDTO;
import com.adote.me.dtl.comment.CommentOutputDTO;
import org.bson.types.ObjectId;

import java.util.List;

public class PublicationOutputDTO {

    private ObjectId id;

    private String description;

    private String imagesBase64;

    private String state;

    private String city;

    private String neighborhood;

    private String creationTimeDate;

    private String changeTimeDate;

    private List<CommentOutputDTO> commentOutputDTOList;

    private PublicationUserOutputDTO publicationUserOutputDTO;

    private AnimalOutputDTO animalOutputDTO;

    public PublicationOutputDTO(ObjectId id, String description, String imagesBase64, String state, String city, String neighborhood, String creationTimeDate, PublicationUserOutputDTO publicationUserOutputDTO, AnimalOutputDTO animalOutputDTO) {
        this.id = id;
        this.description = description;
        this.imagesBase64 = imagesBase64;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.creationTimeDate = creationTimeDate;
        this.publicationUserOutputDTO = publicationUserOutputDTO;
        this.animalOutputDTO = animalOutputDTO;
    }

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

    public List<CommentOutputDTO> getCommentOutputDTOList() {
        return commentOutputDTOList;
    }

    public PublicationUserOutputDTO getPublicationUserOutputDTO() {
        return publicationUserOutputDTO;
    }

    public AnimalOutputDTO getAnimalOutputDTO() {
        return animalOutputDTO;
    }
}
