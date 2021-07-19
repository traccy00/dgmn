package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;

import java.util.List;

public interface ProductService {

  boolean checkExistByName(String name);

  Product saveProduct(Product product) throws BusinessException;

  List<Product> getListProductBySubcategoryId(Long parentCategoryId, Long subcategoryId);

  Product getById(long productId);

  List<Product> getTop8DiscountProduct();

  List<Product> getTop8NewestProduct();
}
