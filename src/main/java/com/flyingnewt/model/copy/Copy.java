package com.flyingnewt.model.copy;

import com.flyingnewt.model.patron.Patron;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Embedded
    private Textbook book;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    private long lastPatronToCheckOutId;

    public void checkOut(long patronID, Date dueDate) {
        this.dueDate = dueDate;
        this.lastPatronToCheckOutId = patronID;
    }

    public void checkIn() {
        this.dueDate = null;
    }
}
