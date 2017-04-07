package com.ssm.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by wuyd on 2017/4/5.
 */
@JsonAutoDetect
public class Account {
    private String name;
    private  double latitude;
    private  double longtitude;
    private String address;
    private String contact;
    private String tellphone;

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }
}
