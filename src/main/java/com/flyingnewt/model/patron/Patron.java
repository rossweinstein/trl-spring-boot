package com.flyingnewt.model.patron;

import com.flyingnewt.model.copy.Copy;
import com.flyingnewt.model.patron.personalInformation.PersonalInformation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long patronId;

    @Embedded
    private PersonalInformation contactInfo;

    @Enumerated(EnumType.STRING)
    private PatronType type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "COPIES_OUT",
    joinColumns = {@JoinColumn(name = "patron_id")}, inverseJoinColumns = {@JoinColumn(name = "copy_id")})
    private List<Copy> copiesOut;

    public Patron(PersonalInformation contact, PatronType type) {
        this.contactInfo = contact;
        this.type = type;
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
