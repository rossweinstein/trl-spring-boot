package com.flyingnewt.model.contact;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Name {

    private String firstName;
    private String lastName;
    private String middleName;

    public String getFullName() {
        return String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    }

    public String getFirstAndLast() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
