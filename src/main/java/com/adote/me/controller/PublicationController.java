package com.adote.me.controller;

import com.adote.me.dtl.publication.PublicationInputDTO;
import com.adote.me.model.Publication;
import com.adote.me.service.PublicationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "publication")
public class PublicationController {

    @Autowired
    private PublicationService service;

    @GetMapping(value = "/publication/{id}")
    public Optional<Publication> getPublicationById(@PathVariable("id") String id) {
        return service.getById(id);
    }

    @PostMapping(value = "/publication")
    public ResponseEntity<?> postPublication(@Valid @RequestBody PublicationInputDTO publicationInputDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(result.getFieldError().getField()+ ": " + result.getFieldError().getDefaultMessage());
        }

        var publication = service.save(publicationInputDTO);
        var publicationOutput = service.converterClassToDto(publication);

        return ResponseEntity.status(HttpStatus.CREATED).body(publicationOutput);
    }

    @GetMapping(value = "/publications")
    public List<Publication> getAllPublications() {
        return service.getAll();
    }

    @DeleteMapping(value = "/publications")
    public void deleteAllPublications() {
        service.deleteAll();
    }

}
