package com.example.basedatos;

public class Adress {
    private String buidings;
    private Integer coord[];
    private String street;
    private String zipcode;

    public Adress() {
    }

    public Adress(String buidings, Integer[] coord, String street, String zipcode) {
        this.buidings = buidings;
        this.coord = coord;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getBuidings() {
        return buidings;
    }

    public void setBuidings(String buidings) {
        this.buidings = buidings;
    }

    public Integer[] getCoord() {
        return coord;
    }

    public void setCoord(Integer[] coord) {
        this.coord = coord;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
