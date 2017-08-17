package com.flyingnewt.model.patron;

import com.flyingnewt.model.contact.Name;
import com.flyingnewt.model.copy.Copy;
import com.flyingnewt.model.contact.ContactInformation;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "patron")
@Getter @Setter
@EqualsAndHashCode @ToString
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patronId;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "name_id")
    private Name name;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "contact_id")
    private ContactInformation contactInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "COPIES_OUT",
    joinColumns = {@JoinColumn(name = "patron_id")},
            inverseJoinColumns = {@JoinColumn(name = "copy_id")})
    private List<Copy> copiesOut;

    public Patron() {
        this.name = new Name();
        this.contactInfo = new ContactInformation();
        this.copiesOut = new ArrayList<>();
    }

    public Patron(Name name, ContactInformation contact) {
        this.name = name;
        this.contactInfo = contact;
        this.copiesOut = new ArrayList<>();
    }

    public boolean hasNoCopiesCheckedOut() {
        return this.copiesOut.isEmpty();
    }

    /***** CHECK COPY OUT METHODS ************************/

    public boolean checkCopyOut(Copy desiredCopy) {
        return desiredCopy.isAvailable() ? patronChecksOutCopy(desiredCopy) : false;
    }

    private boolean patronChecksOutCopy(Copy c) {
        c.checkedOut(this.getPatronId());
        return this.copiesOut.add(c);
    }

    private boolean copyIsAvailable(Copy c) {
        return c.getDueDate() == null;
    }

    /***** CHECK COPY IN METHODS ************************/

    public boolean checkCopyIn(Copy returningCopy) {
        return patronHasCopyCheckedOut(returningCopy) ? this.patronChecksInCopy(returningCopy) : false;
    }

    private boolean patronChecksInCopy(Copy c) {
        c.checkedIn();
        return this.copiesOut.remove(c);
    }

    private boolean patronHasCopyCheckedOut(Copy c) {
        return this.copiesOut.contains(c);
    }

    public int copiesCurrentlyCheckedOut() {
        return this.copiesOut.size();
    }
}
