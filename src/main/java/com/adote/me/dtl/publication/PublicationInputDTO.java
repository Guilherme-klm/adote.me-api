package com.adote.me.dtl.publication;

import com.adote.me.dtl.animal.AnimalInputDTO;
import com.adote.me.model.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

public class PublicationInputDTO {

    private ObjectId id;

    @JsonProperty("description")
    @NotEmpty
    private String description;

    private String imageName;

    @JsonProperty("image")
    private String image;

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

    public ObjectId getId() {
        if (id == null)
            id = new ObjectId();
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImage() {
        return image;
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

    public String convertToFile() {
        if(image != null) {
            var imageName = "C:\\images\\".concat(getId().toString().concat(".jpg"));
            try {
                byte[] decoded = Base64.getDecoder().decode(image);
                InputStream is = new ByteArrayInputStream(decoded);
                BufferedImage bi = ImageIO.read(is);
                ImageIO.write(bi, "jpg", new File(imageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return imageName;
        }
        return null;
    }
}
