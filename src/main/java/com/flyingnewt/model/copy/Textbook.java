package com.flyingnewt.model.copy;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor
public class Textbook {

    private String ISBN;
    private String title;
    private String subTitle;
    private String authorFirst;
    private String authorLast;
    private String publisher;

    @Enumerated(EnumType.STRING)
    private Genre genre;
}
