package com.flyingnewt.model.copy;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "COPY")
@Data
@NoArgsConstructor
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COPY_ID")
    private long id;
    @Embedded
    private Textbook book;
    private LocalDateTime dueDate;
    @Column(name = "LAST_TO_CHECK_OUT")
    private long lastPatronToCheckOutId;

    public Copy(Textbook book, LocalDateTime dueDate, long lastPatronToCheckOutId) {
        this.book = book;
        this.dueDate = dueDate;
        this.lastPatronToCheckOutId = lastPatronToCheckOutId;
    }

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
