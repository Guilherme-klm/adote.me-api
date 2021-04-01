package com.adote.me.model;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "endereco_id")
    private Long id;

    @Column(name = "endereco_pais")
    private String country;

    @Column(name = "endereco_estado")
    private String state;

    @Column(name = "endereco_cidade")
    private String city;

    @Column(name = "endereco_bairro")
    private String neighborhood;

    @Column(name = "endereco_rua")
    private String street;

    @Column(name = "endereco_numero")
    private Long number;

    public Address(String country, String state, String city, String neighborhood, String street, Long number) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
    }

    public Address () {}

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
