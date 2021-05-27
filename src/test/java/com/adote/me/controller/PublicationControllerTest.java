package com.adote.me.controller;

import com.adote.me.fixture.*;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

public class PublicationControllerTest {

    private PublicationFixture fixture;

    @BeforeEach
    public void setup() {
        fixture = new PublicationFixture();
        baseURI = "http://localhost:8080";
        port = 8080;
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void shouldReturnCreatedWhenToPassPublicationAndImageCorrect() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture("name", "breed", vaccine, remedy, disease);

        var json = fixture
                .withDescription("description")
                .withState("state")
                .withCity("city")
                .withNeighborhood("neighborhood")
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", new File("C:\\images\\6eW2hXNi.jpeg"))
                .when()
                .post("/publication")
                .then()
                .statusCode(CREATED.value());
    }

    @Test
    public void shouldReturnErrorWhenToPassDescriptionEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture("name", "breed", vaccine, remedy, disease);

        var json = fixture
                .withDescription(EMPTY)
                .withState("state")
                .withCity("city")
                .withNeighborhood("neighborhood")
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", new File("C:\\images\\6eW2hXNi.jpeg"))
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Descrição não pode ser vazio\"}"));
    }
}
