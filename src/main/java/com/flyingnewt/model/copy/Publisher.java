package com.flyingnewt.model.copy;

import com.flyingnewt.model.contact.ContactInformation;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String companyName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContactInformation contact;

    public Publisher() {}

    public Publisher(String companyName, ContactInformation contact) {
        this.companyName = companyName;
        this.contact = contact;
    }
}
