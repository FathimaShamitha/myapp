package com.example.myapp.model;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("street")
    String street;

    @SerializedName("suite")
    String suite;

    @SerializedName("city")
    String city;

    @SerializedName("zipcode")
    String zipcode;


    @SerializedName("geo")
    Geo geo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
