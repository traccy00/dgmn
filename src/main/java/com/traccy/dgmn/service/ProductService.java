package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;

import java.util.List;

public interface ProductService {

  boolean checkExistByName(String name);

  Product saveProduct(Product product) throws BusinessException;

  List<Product> getListProductByCategoryId(Long categoryId);

  Product getById(long productId);
}
