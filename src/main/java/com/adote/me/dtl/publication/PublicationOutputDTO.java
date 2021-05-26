package com.adote.me.dtl.publication;

import com.adote.me.dtl.animal.AnimalOutputDTO;
import com.adote.me.dtl.comment.CommentOutputDTO;
import com.adote.me.model.Publication;

import java.util.List;

public class PublicationOutputDTO {

    private String id;

    private String description;

    private String imageLink;

    private String state;

    private String city;

    private String neighborhood;

    private String creationTimeDate;

    private String changeTimeDate;

    private List<CommentOutputDTO> commentOutputDTOList;

    private PublicationUserOutputDTO publicationUserOutputDTO;

    private AnimalOutputDTO animalOutputDTO;

    public PublicationOutputDTO (Publication publication) {
        this.id = publication.getId().toString();
        this.description = publication.getDescription();
        this.imageLink = publication.getImagePathName();
        this.state = publication.getState();
        this.city = publication.getCity();
        this.neighborhood = publication.getNeighborhood();
        this.creationTimeDate = publication.getCreationTimeDate();
        this.publicationUserOutputDTO = new PublicationUserOutputDTO(publication.getPublicationUser());
        this.animalOutputDTO = new AnimalOutputDTO(publication.getAnimal());
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImageLink() {
        return imageLink;
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
