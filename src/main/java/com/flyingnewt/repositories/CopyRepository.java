package com.flyingnewt.repositories;

import com.flyingnewt.model.copy.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by rweinstein on 8/16/17.
 */
public interface CopyRepository extends JpaRepository<Copy, Long> {
}
