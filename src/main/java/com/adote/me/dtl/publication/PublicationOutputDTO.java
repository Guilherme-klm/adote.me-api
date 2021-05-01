package com.adote.me.dtl.publication;

import com.adote.me.dtl.animal.AnimalOutputDTO;
import com.adote.me.dtl.comment.CommentOutputDTO;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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

    public PublicationOutputDTO(String id, String description, String imageLink, String state, String city, String neighborhood, String creationTimeDate, PublicationUserOutputDTO publicationUserOutputDTO, AnimalOutputDTO animalOutputDTO) {
        this.id = id;
        this.description = description;
        this.imageLink = imageLink;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.creationTimeDate = creationTimeDate;
        this.publicationUserOutputDTO = publicationUserOutputDTO;
        this.animalOutputDTO = animalOutputDTO;
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
