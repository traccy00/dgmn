package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.model.Mapper;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.repository.ProductRepository;
import com.traccy.dgmn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepository productRepository;

  @Override
  public Product createProduct(Product productRequest) throws BusinessException {
    if(checkExistByName(productRequest.getName().trim())) {
      throw new BusinessException(ResponseMessageConstants.PRODUCT_EXIST);
    }
    if(StringUtils.isBlank(productRequest.getName().trim())) {
      throw new BusinessException(ResponseMessageConstants.PRODUCT_NAME_NOT_BLANK);
    }
    Product productReturn = Mapper.copyFrom(productRequest, Product.class);
    return productReturn;
  }

  @Override
  public boolean checkExistByName(String name) {
    return productRepository.existsByName(name);
  }

  @Override
  public List<Product> getListProductByCategoryId(Long categoryId) {
    if(categoryId == null) {
      return productRepository.findAllByCategoryId(categoryId);
    } else {
      return productRepository.findAll();
    }
  }

}
