package com.flyingnewt.model.contact;

import com.sun.tools.javah.Gen;
import lombok.*;

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
        return String.format("%s %s %s", this.firstName, this.middleName, this.lastName);
    }

    public String getFirstAndLast() {
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
}
