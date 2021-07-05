package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;

import java.util.List;

public interface ProductService {

  boolean checkExistByName(String name);

  Product createProduct(Product productRequest) throws BusinessException;

  List<Product> getListProductByCategoryId(Long categoryId);
}
