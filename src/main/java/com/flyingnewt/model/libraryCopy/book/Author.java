package com.flyingnewt.model.libraryCopy.book;

import com.flyingnewt.model.contactInformation.Name;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "author")
@Getter @Setter
@EqualsAndHashCode @ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_id")
    private Name name;

    public Author() {
        this.name = new Name();
    }

    public Author(Name name) {
        this.name = name;
    }
}
