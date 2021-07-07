package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Product findById(long productId);

  List<Product> findAllByCategoryId(long categoryId);

  boolean existsByName(String name);
}
