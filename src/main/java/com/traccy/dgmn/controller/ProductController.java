package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.service.AdminProductService;
import com.traccy.dgmn.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private AdminProductService adminProductService;

  @PutMapping("/create-product")
  ResponseData createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
    try {
      if(productCreateRequest == null) {
        return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.DATA_INVALID);
      }
      adminProductService.createProduct(productCreateRequest);
      LOGGER.info("create product with {}", productCreateRequest);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.CREATE_PRODUCT_SUCCESS);
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }


}
