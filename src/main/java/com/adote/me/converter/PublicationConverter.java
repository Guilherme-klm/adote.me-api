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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublicationConverter extends BaseConverter {

    private PublicationInputDTO publicationInputDTO;

    private Publication publication;

    private List<Publication> publications;

    private String image;

    public PublicationConverter(PublicationInputDTO publicationInputDTO, String image) {
        this.publicationInputDTO = publicationInputDTO;
        this.image = image;
    }

    public PublicationConverter(Publication publication) {
        this.publication = publication;
    }

    public PublicationConverter(List<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public Object dtoToEntity() {
        var publicationUserInput = publicationInputDTO.getPublicationUserInputDTO();
        var animalInput = publicationInputDTO.getAnimalInputDTO();

        return new Publication(publicationInputDTO.getId(), publicationInputDTO.getDescription(), image, publicationInputDTO.getState(), publicationInputDTO.getCity(), publicationInputDTO.getNeighborhood(), getCurrentDateTime(),
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

        return new PublicationOutputDTO(publication.getId().toString(), publication.getDescription(), publication.getImageNamePath(), publication.getState(), publication.getCity(), publication.getNeighborhood(), publication.getCreationTimeDate(),
                new PublicationUserOutputDTO(publicationUser.getId(), publicationUser.getName()),
                new AnimalOutputDTO(animal.getName(), animal.getBreed(),
                        new VaccineOutputDTO(animal.getVaccine().getName(), animal.getVaccine().getDate(), animal.getVaccine().getValidity()),
                        new RemedyOutputDTO(animal.getRemedy().getName(), animal.getRemedy().getDate(), animal.getRemedy().getValidity()),
                        new DiseaseOutputDTO(animal.getDisease().getName())));
    }

    public List<PublicationOutputDTO> entityListToDtoList() {
        var publicationsOutputDTO = new ArrayList<PublicationOutputDTO>();

        for (var publication : this.publications) {
            publicationsOutputDTO.add(new PublicationOutputDTO(publication.getId().toString(), publication.getDescription(), publication.getImageNamePath(), publication.getState(), publication.getCity(), publication.getNeighborhood(), publication.getCreationTimeDate(),
                    new PublicationUserOutputDTO(publication.getPublicationUser().getId(), publication.getPublicationUser().getName()),
                    new AnimalOutputDTO(publication.getAnimal().getName(), publication.getAnimal().getBreed(),
                            new VaccineOutputDTO(publication.getAnimal().getVaccine().getName(), publication.getAnimal().getVaccine().getDate(), publication.getAnimal().getVaccine().getValidity()),
                            new RemedyOutputDTO(publication.getAnimal().getRemedy().getName(), publication.getAnimal().getRemedy().getDate(), publication.getAnimal().getRemedy().getValidity()),
                            new DiseaseOutputDTO(publication.getAnimal().getDisease().getName()))));
        }
        return publicationsOutputDTO;
    }

    private String getCurrentDateTime() {
        var dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        var date = new Date();
        return dateFormat.format(date);
    }
}
