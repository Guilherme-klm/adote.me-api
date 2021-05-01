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

    @NotEmpty(message = "Descrição não pode ser vazio")
    private String description;

    @NotEmpty(message = "Estado não pode ser vazio")
    private String state;

    @NotEmpty(message = "Cidade não pode ser vazio")
    private String city;

    @NotEmpty(message = "Bairro não pode ser vazio")
    private String neighborhood;

    private List<Comment> comments;

    private PublicationUserInputDTO user;

    private AnimalInputDTO animal;

    public void validateFields() throws Exception {
        validateDescription();
        validateState();
        validateCity();
        validateNeighborhood();
        animal.validateAnimal();
    }

    public ObjectId getId() {
        if (id == null)
            id = new ObjectId();
        return id;
    }

    public String getDescription() {
        return description;
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
        return user;
    }

    public AnimalInputDTO getAnimalInputDTO() {
        return animal;
    }

    private void validateDescription() throws Exception {
        if (description.isEmpty()) {
            throw new Exception(getClass().getDeclaredField("description").getAnnotation(NotEmpty.class).message());
        }
    }

    private void validateState() throws Exception {
        if (state.isEmpty()) {
            throw new Exception(getClass().getDeclaredField("state").getAnnotation(NotEmpty.class).message());
        }
    }

    private void validateCity() throws Exception {
        if (city.isEmpty()) {
            throw new Exception(getClass().getDeclaredField("city").getAnnotation(NotEmpty.class).message());
        }
    }

    private void validateNeighborhood() throws Exception {
        if (neighborhood.isEmpty()) {
            throw new Exception(getClass().getDeclaredField("neighborhood").getAnnotation(NotEmpty.class).message());
        }
    }
}
