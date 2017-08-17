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
    @Column(name = "publisher_id")
    private long id;

    @Column(name = "name")
    private String companyName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContactInformation contact;

    public Publisher() {
        this.companyName = "";
        this.contact = new ContactInformation();
    }

    public Publisher(String companyName, ContactInformation contact) {
        this.companyName = companyName;
        this.contact = contact;
    }
}
