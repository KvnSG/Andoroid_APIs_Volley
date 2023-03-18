package com.example.basedatos;

public class Restaurant {
    private String id;
    private Adress adress;
    private String borough;
    private String cuisine;
    private Integer grades[];
    private String name;
    private String restaurant_id;

    public Restaurant() {
    }

    public Restaurant(String id, Adress adress, String borough, String cuisine, Integer[] grades, String name, String restaurant_id) {
        this.id = id;
        this.adress = adress;
        this.borough = borough;
        this.cuisine = cuisine;
        this.grades = grades;
        this.name = name;
        this.restaurant_id = restaurant_id;
    }

    public Restaurant(String id, String borough, String cuisine,String name, String restaurant_id) {
        this.id = id;
        this.borough = borough;
        this.cuisine = cuisine;
        this.name = name;
        this.restaurant_id = restaurant_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Integer[] getGrades() {
        return grades;
    }

    public void setGrades(Integer[] grades) {
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
