package com.flyingnewt.repositories;

import com.flyingnewt.model.patron.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rweinstein on 8/16/17.
 */
public interface PatronRepository extends JpaRepository<Patron, Long> {

    List<Patron> findByName_LastName(String lastName);
}
