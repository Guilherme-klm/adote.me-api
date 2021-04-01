package com.adote.me.dtl.address;

public class AddressOutputDTO {

    private Long id;

    private String country;

    private String state;

    private String city;

    private String neighborhood;

    private String street;

    private Long number;

    public AddressOutputDTO(Long id, String country, String state, String city, String neighborhood, String street, Long number) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }

    public Long getId() {
        return id;
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

    public Long getNumber() {
        return number;
    }
}
