package com.adote.me.fixture;

public class AnimalFixture {

    private String name;
    private String breed;
    private VaccineFixture vaccine;
    private RemedyFixture remedy;
    private DiseaseFixture disease;

    public AnimalFixture(String name, String breed, VaccineFixture vaccine, RemedyFixture remedy, DiseaseFixture diseaseFixture) {
        this.name = name;
        this.breed = breed;
        this.vaccine = vaccine;
        this.remedy = remedy;
        this.disease = diseaseFixture;
    }

    public AnimalFixture(AnimalFixture animalFixture) {
        this.name = animalFixture.name;
        this.breed = animalFixture.breed;
        this.vaccine = new VaccineFixture(animalFixture.vaccine);
        this.remedy = new RemedyFixture(animalFixture.remedy);
        this.disease = new DiseaseFixture(animalFixture.disease.getName());
    }
}
