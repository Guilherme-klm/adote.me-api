package com.adote.me.controller;

import com.adote.me.fixture.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

public class PublicationControllerTest {

    private PublicationFixture fixture;
    private File image;

    @BeforeEach
    public void setup() {
        fixture = new PublicationFixture();
        baseURI = "https://adote-me-api.herokuapp.com/";
        image = new File("C:\\images\\6eW2hXNi.jpeg");
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
                .multiPart("image", image)
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
                .multiPart("image", image)
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

    @Test
    public void shouldReturnErrorWhenToPassStateEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture("name", "breed", vaccine, remedy, disease);

        var json = fixture
                .withDescription("description")
                .withState(EMPTY)
                .withCity("city")
                .withNeighborhood("neighborhood")
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Estado não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassCityEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture("name", "breed", vaccine, remedy, disease);

        var json = fixture
                .withDescription("description")
                .withState("state")
                .withCity(EMPTY)
                .withNeighborhood("neighborhood")
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Cidade não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassNeighborhoodEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture("name", "breed", vaccine, remedy, disease);

        var json = fixture
                .withDescription("description")
                .withState("state")
                .withCity("city")
                .withNeighborhood(EMPTY)
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Bairro não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassAnimalNameIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture(EMPTY, "breed", vaccine, remedy, disease);

        var json = fixture
                .withDescription("description")
                .withState("state")
                .withCity("city")
                .withNeighborhood("neighborhood")
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Nome não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassAnimalBreedIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", "validity");
        var disease = new DiseaseFixture("name");
        var publicationAnimal =  new AnimalFixture("name", EMPTY, vaccine, remedy, disease);

        var json = fixture
                .withDescription("description")
                .withState("state")
                .withCity("city")
                .withNeighborhood("neighborhood")
                .withPublicationUser(publicationUser)
                .withAnimal(publicationAnimal)
                .convertToJson();

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Raça não pode ser vazia\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassVaccineNameIsEmptyAndDateIsNotNull() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture(EMPTY, "date", EMPTY);
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Nome da vacina não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassVaccineNameAndDateIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture(EMPTY, EMPTY, "validity");
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Nome da vacina não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassVaccineNameIsNotEmptyAndDateIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", EMPTY, "validity");
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Data da vacina não pode ser vazia\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassVaccineNameIsNotEmptyAndValidityIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", EMPTY);
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Validade da vacina não pode ser vazia\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassRemedyNameIsEmptyAndDateIsNotNull() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture(EMPTY, "date", EMPTY);
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Nome do remédio não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassRemedyNameAndDateIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture(EMPTY, EMPTY, "validity");
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Nome do remédio não pode ser vazio\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassRemedyNameIsNotEmptyAndDateIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", EMPTY, "validity");
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Data do remédio não pode ser vazia\"}"));
    }

    @Test
    public void shouldReturnErrorWhenToPassRemedyNameIsNotEmptyAndValidityIsEmpty() {
        var publicationUser = new PublicationUserFixture(1L, "teste");
        var vaccine = new VaccineFixture("name", "date", "validity");
        var remedy = new RemedyFixture("name", "date", EMPTY);
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

        var response = given()
                .queryParam("publication", json)
                .and()
                .multiPart("image", image)
                .when()
                .post("/publication")
                .then()
                .extract()
                .response();

        response
                .then()
                .statusCode(NOT_ACCEPTABLE.value())
                .assertThat()
                .body(containsString("{\"errorMessage\":\"Validade do remédio não pode ser vazia\"}"));
    }

}
