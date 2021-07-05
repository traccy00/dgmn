package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
  boolean existsById(long id);
}
