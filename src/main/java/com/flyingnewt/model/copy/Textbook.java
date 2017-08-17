package com.flyingnewt.model.copy;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
public class Textbook {

    private String ISBN;
    private String title;
    private String subTitle;
    private String authorFirst;
    private String authorLast;
    private String publisher;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Textbook() {}

    public Textbook(String ISBN, String title, String subTitle, String authorFirst, String authorLast, String publisher, Genre genre) {
        this.ISBN = ISBN;
        this.title = title;
        this.subTitle = subTitle;
        this.authorFirst = authorFirst;
        this.authorLast = authorLast;
        this.publisher = publisher;
        this.genre = genre;
    }
}
