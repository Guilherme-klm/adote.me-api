package com.adote.me.converter;

import com.adote.me.dtl.animal.AnimalOutputDTO;
import com.adote.me.dtl.disease.DiseaseOutputDTO;
import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.dtl.publication.PublicationOutputDTO;
import com.adote.me.dtl.publication.PublicationUserOutputDTO;
import com.adote.me.dtl.remedy.RemedyOutputDTO;
import com.adote.me.dtl.vaccine.VaccineOutputDTO;
import com.adote.me.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicationConverter extends BaseConverter {

    private PublicationInputDTO publicationInputDTO;

    private Publication publication;

    public PublicationConverter(PublicationInputDTO publicationInputDTO) {
        this.publicationInputDTO = publicationInputDTO;
    }

    public PublicationConverter(Publication publication) {
        this.publication = publication;
    }

    @Override
    public Object dtoToEntity() {
        var publicationUserInput = publicationInputDTO.getPublicationUserInputDTO();
        var animalInput = publicationInputDTO.getAnimalInputDTO();

        return new Publication(publicationInputDTO.getId(), publicationInputDTO.getDescription(),publicationInputDTO.convertToFile(), publicationInputDTO.getState(), publicationInputDTO.getCity(), publicationInputDTO.getNeighborhood(), getCurrentDateTime(),
                new PublicationUser(publicationUserInput.getId(), publicationUserInput.getName()),
                new Animal(animalInput.getName(), animalInput.getBreed(),
                        new Vaccine(animalInput.getVaccineInputDTO().getName(), animalInput.getVaccineInputDTO().getDate(), animalInput.getVaccineInputDTO().getValidity()),
                        new Remedy(animalInput.getRemedyInputDTO().getName(), animalInput.getRemedyInputDTO().getDate(), animalInput.getRemedyInputDTO().getValidity()),
                        new Disease(animalInput.getDiseaseInputDTO().getName())));
    }

    @Override
    public Object entityToDto() {
        var publication = this.publication;
        var publicationUser = this.publication.getPublicationUser();
        var animal = this.publication.getAnimal();

        return new PublicationOutputDTO(publication.getId().toString(), publication.getDescription(), publication.getImagesBase64(), publication.getState(), publication.getCity(), publication.getNeighborhood(), publication.getCreationTimeDate(),
                new PublicationUserOutputDTO(publicationUser.getId(), publicationUser.getName()),
                new AnimalOutputDTO(animal.getName(), animal.getBreed(),
                        new VaccineOutputDTO(animal.getVaccine().getName(), animal.getVaccine().getDate(), animal.getVaccine().getValidity()),
                        new RemedyOutputDTO(animal.getRemedy().getName(), animal.getRemedy().getDate(), animal.getRemedy().getValidity()),
                        new DiseaseOutputDTO(animal.getDisease().getName())));
    }

    public String getCurrentDateTime () {
        var dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        var date = new Date();
        return dateFormat.format(date);
    }
}
