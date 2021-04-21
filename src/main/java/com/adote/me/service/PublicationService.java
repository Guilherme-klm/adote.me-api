package com.adote.me.service;

import com.adote.me.converter.PublicationConverter;
import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.dtl.publication.PublicationOutputDTO;
import com.adote.me.model.Publication;
import com.adote.me.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository repository;

    private PublicationConverter publicationConverter;

    public PublicationOutputDTO save(PublicationInputDTO publicationInputDTO) {
        var publication = converterDtoToClass(publicationInputDTO);
        var publicationSaved = repository.save(publication);
        var publicationOutputDTO = converterClassToDto(publicationSaved);
        return publicationOutputDTO;
    }

    public List<PublicationOutputDTO> findAllByLocalization(String localization, String value) {
        var publications = getPublicationsByLocalization(localization, value);

        if (publications.size() > 0)
            return converterClassListToDtoList(publications);

        return null;
    }

    public Optional<Publication> getById(String id) {
        return repository.findById(id);
    }

    private List<Publication> getPublicationsByLocalization(String localization, String value) {
        return repository.findByPublicationByLocalization(localization, value);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Publication converterDtoToClass(PublicationInputDTO publicationInputDTO) {
        publicationConverter = new PublicationConverter(publicationInputDTO);
        return (Publication) publicationConverter.dtoToEntity();
    }

    private PublicationOutputDTO converterClassToDto(Publication publication) {
        publicationConverter = new PublicationConverter(publication);
        return (PublicationOutputDTO) publicationConverter.entityToDto();
    }

    private List<PublicationOutputDTO> converterClassListToDtoList(List<Publication> publications) {
        publicationConverter = new PublicationConverter(publications);
        return publicationConverter.entityListToDtoList();
    }
}
