package com.flyingnewt.model.contact;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "contact")
@Getter @Setter
@EqualsAndHashCode @ToString
public class ContactInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private long id;

    @Embedded
    private Address mailingAddress;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private EmailAddress emailAddress;

    public ContactInformation() {
        this.mailingAddress = new Address();
        this.phoneNumber = new PhoneNumber();
        this.emailAddress = new EmailAddress();
    }

    public ContactInformation(Address mailingAddress, PhoneNumber phoneNumber, EmailAddress emailAddress) {
        this.mailingAddress = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
}
