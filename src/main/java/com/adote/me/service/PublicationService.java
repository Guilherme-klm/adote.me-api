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

    public Publication save (PublicationInputDTO publicationInputDTO) {
        var publication = converterDtoToClass(publicationInputDTO);
        return repository.save(publication);
    }

    public Optional<Publication> getById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public List<Publication> getAll() {
        return repository.findAll();
    }

    public List<PublicationOutputDTO> getPublicationsByLocalization(String localization,String value) {
        return repository.findByPublicationByLocalization(localization, value);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Publication converterDtoToClass(PublicationInputDTO publicationInputDTO) {
        publicationConverter = new PublicationConverter(publicationInputDTO);
        return (Publication) publicationConverter.dtoToEntity();
    }

    public PublicationOutputDTO converterClassToDto(Publication publication) {
        publicationConverter = new PublicationConverter(publication);
        return (PublicationOutputDTO) publicationConverter.entityToDto();
    }
}
