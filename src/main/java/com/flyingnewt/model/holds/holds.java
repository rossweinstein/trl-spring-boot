package com.flyingnewt.model.holds;

import com.flyingnewt.model.copy.Copy;
import com.flyingnewt.model.patron.Patron;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.FetchMode;
import org.hibernate.service.spi.InjectService;

import javax.persistence.*;

@Entity(name = "holds")
@Getter @Setter
@EqualsAndHashCode @ToString
public class holds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hold_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patron_id")
    private Patron offending_patron;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "copy_id")
    private Copy copy;

    @Enumerated(EnumType.STRING)
    private HoldType holdType;

    private int fine;
    private boolean resolved;

    public holds() {
        this.offending_patron = new Patron();
        this.copy = new Copy();
        this.holdType = HoldType.MISC;
        this.fine = 0;
        this.resolved = false;
    }

    public holds(Patron offending_patron, Copy copy, HoldType holdType, int fine, boolean resolved) {
        this.offending_patron = offending_patron;
        this.copy = copy;
        this.holdType = holdType;
        this.fine = fine;
        this.resolved = resolved;
    }
}
