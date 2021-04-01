package com.adote.me.dtl.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class AddressInputDTO {

    @NotEmpty(message = "País inválido")
    @JsonProperty("country")
    private String country;

    @NotEmpty(message = "Estado inválido")
    @JsonProperty("state")
    private String state;

    @NotEmpty(message = "Cidade inválido")
    @JsonProperty("city")
    private String city;

    @NotEmpty(message = "Bairro inválido")
    @JsonProperty("neighborhood")
    private String neighborhood;

    @NotEmpty(message = "Rua inválida")
    @JsonProperty("street")
    private String street;

    @PositiveOrZero(message = "Número não pode ser negativo")
    @JsonProperty("number")
    @NotNull
    private long number;

    public AddressInputDTO(String country, String state, String city, String neighborhood, String street, Long number) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }

    public AddressInputDTO() {
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public long getNumber() {
        return number;
    }
}
