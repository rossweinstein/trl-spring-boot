package com.flyingnewt.model.contactInformation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "name")
@Getter @Setter
@EqualsAndHashCode @ToString
public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first")
    private String firstName;
    @Column(name = "middle")
    private String middleName;
    @Column(name = "last")
    private String lastName;

    public String getFullName() {
        if (this.hasFullName()) {
            return this.formattedFullName();
        } else if (this.hasFirstAndLast()) {
            return this.formattedFirstAndLast();
        } else {
            return "";
        }
    }

    private boolean hasFullName() {
        return !this.firstName.isEmpty()&& !this.middleName.isEmpty() && !this.lastName.isEmpty();
    }

    private boolean hasFirstAndLast() {
        return !this.firstName.isEmpty() && this.middleName.isEmpty() && !this.lastName.isEmpty();
    }

    private String formattedFullName() {
        return String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    }

    private String formattedFirstAndLast() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

    public Name() {
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "";
        this.lastName = lastName;
    }
}