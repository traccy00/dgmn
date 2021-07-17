package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Category findByName(String name);

  @Query(value = "select * from categories c where c.is_subcategory = 1 and c.status = 1 and c.id = ?1", nativeQuery = true)
  Category getSubcategoryById(long id);

  Category findById(long id);

  boolean existsById(long id);
}
