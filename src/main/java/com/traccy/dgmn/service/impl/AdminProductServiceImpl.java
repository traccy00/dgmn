package com.traccy.dgmn.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traccy.dgmn.config.constant.ActivityActionConstants;
import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.entity.ShopInformation;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.model.request.ShopInformationCreateRequest;
import com.traccy.dgmn.service.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

  @Autowired
  private ShopInformationService shopInformationService;

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
    Category category = categoryService.getSubCategoryById(categoryId);
    if (category == null) {
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
    //price: default=0 not null
    if (productInformation.getPrice() < 0) {
      throw new BusinessException(ResponseMessageConstants.PRICE_GREATER_THAN_0);
    }
    product.setPrice(productInformation.getPrice());
    //stocking:default:Stocking not null
    if (productInformation.getStocking() != Enums.StockingStatus.Stocking.getStatus() && productInformation
      .getStocking() != Enums.StockingStatus.Order.getStatus()) {
      product.setStocking(Enums.StockingStatus.Stocking.getStatus());
    } else {
      product.setStocking(productInformation.getStocking());
    }
    //size
    product.setSize(productInformation.getSize());
    //warranty
    product.setWarranty(productInformation.getWarranty());
    //shipping fee:default:Free
    if (productInformation.getShippingFee() != Enums.ShippingFee.Free.getStatus() && productInformation
      .getShippingFee() != Enums.ShippingFee.Contact.getStatus()) {
      product.setShippingFee(Enums.ShippingFee.Free.getStatus());
    } else {
      product.setShippingFee(productInformation.getShippingFee());
    }
    product.setStatus(true);
    product.create();
    LOGGER.info(productInformation.toString());
    Product product1 = productService.saveProduct(product);
    activityService.logActivityData(ActivityActionConstants.CREATE_PRODUCT, beforeData,
      new ObjectMapper().writeValueAsString(product1));
    return product;
  }

  @Override
  public void createShopInformation(ShopInformationCreateRequest request) throws Exception {
    int countNumberOfInformation = shopInformationService.getNumberOfShop();
    if (countNumberOfInformation == 5) {
      throw new BusinessException(ResponseMessageConstants.SHOP_INFORMATION_QUANTITY_LIMIT);
    }
    if (StringUtils.isBlank(request.getName().trim()) || StringUtils.isBlank(request.getAddress().trim())) {
      throw new BusinessException(ResponseMessageConstants.FIELD_NOT_BLANK);
    }
    List<String> phoneNumberList = request.getPhoneNumberList();
    //validate field for save
    if (phoneNumberList.isEmpty() || phoneNumberList == null) {
      throw new BusinessException(ResponseMessageConstants.FIELD_NOT_BLANK);
    }
    List<String> trimmedStrings = phoneNumberList.stream().map(String::trim).collect(Collectors.toList());
    if (trimmedStrings.contains("")) {
      throw new BusinessException(ResponseMessageConstants.FIELD_NOT_BLANK);
    }
    String phoneNumberForSave = "";
    for (String str : trimmedStrings) {
      phoneNumberForSave += str + ", ";
    }
    String beforeData = new ObjectMapper().writeValueAsString(null);
    ShopInformation shopInformation = new ShopInformation();
    shopInformation.setName(request.getName());
    shopInformation.setAddress(request.getAddress());
    shopInformation.setPhoneNumber(phoneNumberForSave);
    shopInformation.create();
    shopInformation.setStatus(true);
    ShopInformation shopInformationSaved = shopInformationService.saveShopInformation(shopInformation);
    String afterData = new ObjectMapper().writeValueAsString(shopInformationSaved);
    activityService.logActivityData(ActivityActionConstants.CREATE_SHOP_INFORMATION, beforeData, afterData);
  }
}
