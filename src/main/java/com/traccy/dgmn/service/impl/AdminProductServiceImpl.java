package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
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

  @Override
  @Transactional(rollbackOn = BusinessException.class)
  public void createProduct(ProductCreateRequest productCreateRequest) throws BusinessException {
    //create product
    Product product = createProductInformation(productCreateRequest);
    //create image
    List<Image> imageListRequest = productCreateRequest.getImageList();
    long productId = product.getId();
    createImageListOfProduct(imageListRequest, productId);
  }

  @Override
  public Product createProductInformation(ProductCreateRequest productCreateRequest)
    throws BusinessException {
    Product product = productCreateRequest.getProduct();
    long categoryId = product.getCategoryId();
    if(!categoryService.checkExistById(categoryId)) {
      throw new BusinessException(ResponseMessageConstants.CATEGORY_NOT_EXIST);
    }
    long unitId = product.getUnitId();
    if(unitService.checkExistById(unitId)) {
      throw new BusinessException(ResponseMessageConstants.UNIT_NOT_EXIST);
    }
    LOGGER.info(product.toString());
    Product productCreate = productService.createProduct(product);
    if(productCreate == null) {
      throw new BusinessException(ResponseMessageConstants.CREATE_PRODUCT_FAIL);
    }
    return productCreate;
  }

  @Override
  public void createImageListOfProduct(List<Image> imageListRequest, long productId) {
    if(!imageListRequest.isEmpty()) {
      configService.saveImageProduct(imageListRequest, productId);
    }
  }
}
