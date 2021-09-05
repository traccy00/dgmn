package com.traccy.dgmn.repository;

import com.traccy.dgmn.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Product findById(long productId);

  @Query(value = "select * from products p where (p.category_id = :subcategoryId or 0 = :subcategoryId) " +
    "and p.category_id in (:listId) and p.status = 1", nativeQuery = true)
  List<Product> getListProductBySubcategoryId(@Param("listId") List<Long> listSubcategoryOfParent,
    @Param("subcategoryId") long subcategoryId);

  boolean existsByName(String name);

  @Query(value = "select TOP(8) * from products p where p.status = 1 order by created_at desc", nativeQuery = true)
  List<Product> getTop8NewestProduct();

  @Query(value = "select * from products p where p.status = 1", nativeQuery = true)
  List<Product> findAllProduct();
}
