package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.repository.ProductRepository;
import com.traccy.dgmn.service.CategoryService;
import com.traccy.dgmn.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CategoryService categoryService;

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
  public List<Product> getListProductBySubcategoryId(Long parentCategoryId, Long subcategoryId) {
    List<Long> listSubcategoryOfParent = categoryService.getListIdByParentCategoryId(parentCategoryId);
    if(subcategoryId == null) {
      return productRepository.getListProductByParentCategoryId(listSubcategoryOfParent);
    } else {
      return productRepository.getListProductBySubcategoryId(listSubcategoryOfParent, subcategoryId);
    }
  }

  @Override
  public Product getById(long productId) {
    return productRepository.findById(productId);
  }

  @Override
  public List<Product> getTop8DiscountProduct() {
    return productRepository.getTop8DiscountProduct();
  }

  @Override
  public List<Product> getTop8NewestProduct() {
    return productRepository.getTop8NewestProduct();
  }

}
