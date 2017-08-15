package com.flyingnewt.model.patron.personalInformation;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {

    private String number;

    public PhoneNumber() {
        this.number = "";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = this.isValidPhoneNumber(number) ? number : "";
    }

    public PhoneNumber(String phoneNumber) {
        this.number = this.isValidPhoneNumber(phoneNumber) ? phoneNumber : "";
    }

    public String getFormattedTelephoneNumber() {
        return isListed() ? this.formatedNumber() : "";
    }

    private String formatedNumber() {
        return this.number.substring(0, 3) + "." + this.number.substring(3, 6) + "."
                + this.number.substring(6);
    }

    private boolean isListed() {
        return !this.number.isEmpty();
    }

    private boolean isValidPhoneNumber(String number) {
        return number.length() == 10 && number.chars().allMatch(Character::isDigit);
    }
}
