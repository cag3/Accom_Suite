package com.devstudio.mlabsa.accom.dto;

import java.io.Serializable;

/**
 * Created by CodeTribe on 2015-04-11.
 */
public class AccommodationDTO implements Serializable {
    private Integer accommodationID;
    private String fullName;
    private Integer phoneNumber;
    private String email;
    private String address;
    private String description;
    private String dwellingType;
    private Integer bedroom;
    private float price;

    public AccommodationDTO() {
    }

    public AccommodationDTO(Integer accommodationID, String fullName, Integer phoneNumber, String email, String address, String description, String dwellingType, Integer bedroom, float price) {
        this.accommodationID = accommodationID;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.description = description;
        this.dwellingType = dwellingType;
        this.bedroom = bedroom;
        this.price = price;
    }

    public Integer getAccommodationID() {
        return accommodationID;
    }

    public void setAccommodationID(Integer accommodationID) {
        this.accommodationID = accommodationID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDwellingType() {
        return dwellingType;
    }

    public void setDwellingType(String dwellingType) {
        this.dwellingType = dwellingType;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
