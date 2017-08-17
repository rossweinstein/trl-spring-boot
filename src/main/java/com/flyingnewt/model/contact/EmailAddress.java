package com.flyingnewt.model.contact;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.Embeddable;

@Embeddable
public class EmailAddress {

    private String email;

    public EmailAddress() {
        this.email = "";
    }

    public EmailAddress(String email) {
        this.email = this.validateEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = this.validateEmail(email);
    }

    private String validateEmail(String email) {
        return isEmailValid(email) ? email : "";
    }

    private boolean isEmailValid(String email) {

        try {
            InternetAddress theEmailAddress = new InternetAddress(email);
            theEmailAddress.validate();
            return true;
        } catch (AddressException e) {
            System.out.println("Bad Email");
        }

        return false;
    }
}
