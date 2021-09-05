package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;

import java.util.List;

public interface ProductService {

  boolean checkExistByName(String name);

  Product saveProduct(Product product) throws BusinessException;

  List<Product> getListProductBySubcategoryId(long parentCategoryId, long subcategoryId);

  Product getById(long productId);

  List<Product> getTop8NewestProduct();
}
