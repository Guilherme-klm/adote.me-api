package com.adote.me.fixture;

public class RemedyFixture {

    private String name;
    private String date;
    private String validity;

    public RemedyFixture(String name, String date, String validity) {
        this.name = name;
        this.date = date;
        this.validity = validity;
    }

    public RemedyFixture(RemedyFixture fixture) {
        this.name = fixture.name;
        this.date = fixture.date;
        this.validity = fixture.validity;
    }
}
