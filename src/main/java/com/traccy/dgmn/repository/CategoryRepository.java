package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Category findByName(String name);

  boolean existsById(long id);
}
