package com.flyingnewt.model.contactInformation.Address;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Embeddable
@EqualsAndHashCode
@ToString
public class Address {

    private String line1;
    private String line2;
    private String city;
    @Enumerated(EnumType.STRING)
    private USState state;
    @Column(name = "zip_code")
    private String zipCode;

    public Address() {}

    public Address(String line1, String line2, String city, USState state, String zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public USState getState() {
        return state;
    }

    public void setState(USState state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = this.validateZipCode(zipCode);
    }

    private String validateZipCode(String zipCode) {

        return isValidZipCode(zipCode) ? zipCode : "";
    }

    private boolean isValidZipCode(String zipCode) {
        return zipCode.length() == 5 || zipCode.length() == 9 && zipCode.chars().allMatch(Character::isDigit);
    }


}
