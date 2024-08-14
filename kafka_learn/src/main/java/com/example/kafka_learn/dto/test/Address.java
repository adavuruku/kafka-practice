package com.example.kafka_learn.dto.test;

/**
 * Created by Sherif.Abdulraheem 14/08/2024 - 01:10
 **/
public class Address {
    String phoneNo;
    String country;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String state;
    String city;
}
