package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.model.Mapper;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;
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
  public boolean checkExistByName(String name) {
    return productRepository.existsByName(name);
  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getListProductByCategoryId(Long categoryId) {
    if(categoryId == null) {
      return productRepository.findAll();
    } else {
      return productRepository.findAllByCategoryId(categoryId);
    }
  }

  @Override
  public Product getById(long productId) {
    return productRepository.findById(productId);
  }

}
