package com.flyingnewt.model.contactInformation;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.lang.reflect.Array;
import java.util.Arrays;

@Embeddable
@EqualsAndHashCode @ToString
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
        if (this.isEmailValid(email)) {
            this.email = email;
        }
    }

    private String validateEmail(String email) {
        return isEmailValid(email) ? email : "";
    }

    private boolean isEmailValid(String email) {
        String[] parts = email.split("@");
        return parts.length == 2 && parts[1].split("\\.").length == 2;
    }
}
