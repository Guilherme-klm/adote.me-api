package com.adote.me.bl;

import com.adote.me.converter.PublicationConverter;
import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.dtl.publication.PublicationOutputDTO;
import com.adote.me.model.Publication;
import com.adote.me.repository.PublicationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository repository;

    @Autowired
    private FileStorage storageService;

    private PublicationConverter publicationConverter;

    public void save(PublicationInputDTO publicationInputDTO, MultipartFile image) {
        var imageNamePath = storageService.storeFile(image);
        var publication = converterDtoToClass(publicationInputDTO, imageNamePath);
        repository.save(publication);
        storageService.saveImageInFolder();
    }

    public PublicationOutputDTO getPublicationById(String id) {
        Publication publication = getById(id).get();
        return convertClassToDto(publication);
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

    public Publication converterDtoToClass(PublicationInputDTO publicationInputDTO, String image) {
        publicationConverter = new PublicationConverter(publicationInputDTO, image);
        return (Publication) publicationConverter.dtoToEntity();
    }

    private List<PublicationOutputDTO> converterClassListToDtoList(List<Publication> publications) {
        publicationConverter = new PublicationConverter(publications);
        return publicationConverter.entityListToDtoList();
    }

    private PublicationOutputDTO convertClassToDto (Publication publication) {
        publicationConverter = new PublicationConverter(publication);
        return (PublicationOutputDTO) publicationConverter.entityToDto();
    }
}
