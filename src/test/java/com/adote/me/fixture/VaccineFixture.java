package com.adote.me.fixture;

public class VaccineFixture {

    private String name;
    private String date;
    private String validity;

    public VaccineFixture(String name, String date, String validity) {
        this.name = name;
        this.date = date;
        this.validity = validity;
    }

    public VaccineFixture(VaccineFixture fixture) {
        this.name = fixture.name;
        this.date = fixture.date;
        this.validity = fixture.validity;
    }
}
