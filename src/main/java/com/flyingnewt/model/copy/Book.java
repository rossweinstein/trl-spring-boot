package com.flyingnewt.model.copy;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "book")
@Setter @Getter
@EqualsAndHashCode @ToString
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private long id;
    private String isbn;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;

    private String title;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name = "pub_year")
    private String publicationYear;

    public Book() {
        this.isbn = "";
        this.authors = new HashSet<>();
        this.title = "";
        this.publisher = new Publisher();
        this.genre = Genre.FICTION;
        this.publicationYear = "";
    }

    public Book(String isbn, Set<Author> authors, String title, Publisher publisher, Genre genre, String publicationYear) {
        this.isbn = isbn;
        this.authors = authors;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }
}
