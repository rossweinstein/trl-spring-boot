package com.flyingnewt.repositories;

import com.flyingnewt.model.libraryCopy.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by rweinstein on 8/16/17.
 */
public interface CopyRepository extends JpaRepository<Copy, Long> {

    List<Copy> findByDamagedIsFalse ();
}
