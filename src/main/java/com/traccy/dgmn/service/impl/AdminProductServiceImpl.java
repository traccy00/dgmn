package com.traccy.dgmn.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.traccy.dgmn.config.constant.ActivityActionConstants;
import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AdminProductServiceImpl.class);
  @Autowired
  private CategoryService categoryService;

  @Autowired
  private UnitService unitService;

  @Autowired
  private ProductService productService;

  @Autowired
  private ConfigService configService;

  @Autowired
  private ActivityService activityService;

  @Override
  @Transactional(rollbackOn = BusinessException.class)
  public void createProduct(ProductCreateRequest productCreateRequest) throws Exception {
    //create product
    ProductInformation productInformation = productCreateRequest.getProductInformation();
    Product product = createProductInformation(productInformation);
    //create image
    long productId = product.getId();
    List<String> imageList = productCreateRequest.getImageList();
    if (!imageList.isEmpty()) {
      configService.saveImagesOfProduct(imageList, productId);
    } else {
      throw new BusinessException(ResponseMessageConstants.UPLOAD_AVATAR);
    }
  }

  @Override
  public Product createProductInformation(ProductInformation productInformation) throws Exception {
    //check product exist by name
    boolean checkProductExistByName = productService.checkExistByName(productInformation.getName());
    if (checkProductExistByName) {
      throw new BusinessException(ResponseMessageConstants.PRODUCT_EXIST);
    }
    //check category exist
    long categoryId = productInformation.getCategoryId();
    if (!categoryService.checkExistById(categoryId)) {
      throw new BusinessException(ResponseMessageConstants.CATEGORY_NOT_EXIST);
    }
    //check unit id exist
    long unitId = productInformation.getUnitId();
    if (!unitService.checkExistById(unitId)) {
      throw new BusinessException(ResponseMessageConstants.UNIT_NOT_EXIST);
    }
    String beforeData = new ObjectMapper().writeValueAsString(null);
    Product product = new Product();
    product.setName(productInformation.getName());
    product.setDescription(productInformation.getDescription());
    product.setCategoryId(categoryId);
    product.setUnitId(unitId);
    product.setStatus(true);
    product.create();
    LOGGER.info(productInformation.toString());
    Product product1 = productService.createProduct(product);
    activityService.logActivityData(ActivityActionConstants.CREATE_PRODUCT, beforeData,
      new ObjectMapper().writeValueAsString(product1));
    return product;
  }
}
