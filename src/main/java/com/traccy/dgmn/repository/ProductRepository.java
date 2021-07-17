package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Product findById(long productId);

  @Query(value = "select * from products p where p.category_id = ?1 and p.status = 1", nativeQuery = true)
  List<Product> getListProductByCategoryId(long categoryId);

  boolean existsByName(String name);
}
