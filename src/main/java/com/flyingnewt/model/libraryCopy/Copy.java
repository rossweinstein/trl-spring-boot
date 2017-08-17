package com.flyingnewt.model.libraryCopy;

import com.flyingnewt.model.libraryCopy.book.Book;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "copy")
@Getter @Setter
@EqualsAndHashCode @ToString
public class Copy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "copy_id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date")
    private Date dueDate;

    private boolean damaged;
    private boolean lost;
    private boolean sold;

    public Copy() {
        this.book = null;
        this.dueDate = null;
        this.damaged = false;
        this.lost = false;
        this.sold = false;
    }

    public Copy(Book book, Date dueDate) {
        this.book = book;
        this.dueDate = dueDate;
        this.damaged = false;
        this.lost = false;
        this.sold = false;
    }

    public void checkOut(long patronID, Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isAvailable() {
        return this.dueDate == null;
    }

    public void checkedOut(long patronId) {
        this.dueDate = new Date();
    }

    public void checkedIn() {
        this.dueDate = null;
    }
}
