package com.todo.manager.models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipcode;
    private String country;

    //constructor
    public Address(String street, String city, String zipcode, String country) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Address() {

    }

    //getters
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getZipcode() {
        return zipcode;
    }
    public String getCountry() {
        return country;
    }

    //setters
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
