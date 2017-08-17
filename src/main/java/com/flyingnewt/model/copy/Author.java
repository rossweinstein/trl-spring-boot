package com.flyingnewt.model.copy;

import com.flyingnewt.model.contact.Name;
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
    @Column(name = "name_id")
    private Name name;

    public Author() {
        this.name = new Name();
    }

    public Author(Name name) {
        this.name = name;
    }
}
