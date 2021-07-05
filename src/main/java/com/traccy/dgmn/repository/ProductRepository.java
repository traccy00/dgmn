package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAllByCategoryId(Long categoryId);

  boolean existsByName(String name);
}
