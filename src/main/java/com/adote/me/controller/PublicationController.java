package com.adote.me.controller;

import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.dtl.publication.PublicationOutputDTO;
import com.adote.me.exception.ErrorResponse;
import com.adote.me.model.Publication;
import com.adote.me.service.FileStorage;
import com.adote.me.service.PublicationService;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@Tag(name = "publication")
public class PublicationController {

    @Autowired
    private PublicationService service;

    @Autowired
    private FileStorage storageService;

    @GetMapping(value = "/publication/{id}")
    public Optional<Publication> getPublicationById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PostMapping(value = "/publication")
    @ResponseBody
    public ResponseEntity<?> postPublication(@RequestParam("publication") String publicationInputDTO) {
        try {
            var publication = new Gson().fromJson(publicationInputDTO, PublicationInputDTO.class);
            publication.validateFields();
            service.save(publication, null);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(NOT_ACCEPTABLE).body(new ErrorResponse(e.getMessage()).createErrorMessage());
        }
    }

    @GetMapping(value = "/publication/{localization}/{value}")
    public ResponseEntity<List<PublicationOutputDTO>> getAllPublications(@PathVariable("localization") String localization ,@PathVariable("value") String value) {
        var publications = service.findAllByLocalization(localization, value);

        if(publications != null)
            return ResponseEntity.ok(publications);

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/image/{publication_id}", produces = "image/jpg")
    public byte[] getImages(@PathVariable("publication_id") String id) throws IOException {
        Optional<Publication> publication = service.getById(id);

        if(publication.isPresent() && publication.get().getImageNamePath() != null){
            BufferedImage image = ImageIO.read(new File(publication.get().getImageNamePath()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return bytes;
        }
        return null;
    }
}
