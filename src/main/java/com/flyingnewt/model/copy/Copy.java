package com.flyingnewt.model.copy;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Embedded
    private Textbook book;
    private LocalDateTime dueDate;
    private long lastPatronToCheckOutId;

    public void checkOut(long patronID, LocalDateTime dueDate) {
        this.dueDate = dueDate;
        this.lastPatronToCheckOutId = patronID;
        this.lastPatronToCheckOutId = -1;
    }

    public boolean isAvailable() {
        return this.dueDate == null;
    }

    public void checkedOut(long patronId) {
        this.lastPatronToCheckOutId = patronId;
        this.dueDate = LocalDateTime.now().plusDays(100);
    }

    public void checkedIn() {
        this.dueDate = null;
    }
}
