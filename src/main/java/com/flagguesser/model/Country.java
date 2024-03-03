package com.flagguesser.model;

public class Country {

    private int countryId;
    private String name;
    private String code;
    private String capital;
    private String continent;
    private String flagImage;

    public Country() {

    }

    public Country(int countryId, String name, String code, String capital, String continent, String flagImage) {
        this.countryId = countryId;
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.continent = continent;
        this.flagImage = flagImage;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }
}
