package com.adote.me.converter;

import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.dtl.publication.PublicationOutputDTO;
import com.adote.me.model.Publication;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

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
       return new Publication().publicationBuilder(publicationInputDTO, image);
    }

    @Override
    public Object entityToDto() {
        Function<Publication, PublicationOutputDTO> publicationOutput = PublicationOutputDTO::new;
        return publicationOutput.apply(publication);
    }

    public List<PublicationOutputDTO> entityListToDtoList() {
        var publicationsOutputDTO = new ArrayList<PublicationOutputDTO>();

        this.publications.forEach(publication1 -> publicationsOutputDTO.add(new PublicationOutputDTO(publication1)));

        return publicationsOutputDTO;
    }
}
