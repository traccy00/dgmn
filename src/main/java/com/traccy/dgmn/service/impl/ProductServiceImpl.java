package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.repository.ProductRepository;
import com.traccy.dgmn.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepository productRepository;

  @Override
  public boolean checkExistByName(String name) {
    return productRepository.existsByName(name);
  }

  @Override
  public Product saveProduct(Product product) throws BusinessException {
    //check name of product
    if (StringUtils.isBlank(product.getName().trim()) || product.getName() == null) {
      throw new BusinessException(ResponseMessageConstants.PRODUCT_NAME_NOT_BLANK);
    }
    return productRepository.save(product);
  }

  @Override
  public List<Product> getListProductByCategoryId(Long categoryId) {
    if(categoryId == null) {
      return productRepository.findAll();
    } else {
      return productRepository.getListProductByCategoryId(categoryId);
    }
  }

  @Override
  public Product getById(long productId) {
    return productRepository.findById(productId);
  }

}
