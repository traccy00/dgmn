package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.response.CategoryResponse;
import com.traccy.dgmn.service.ConfigService;
import com.traccy.dgmn.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/config")
public class ConfigController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

  @Autowired
  private ProductService productService;

  @Autowired
  private ConfigService configService;

  @PutMapping("/create-category")
  ResponseData createCategory(@RequestBody CategoryRequest categoryRequest) {
    try {
      CategoryResponse categoryResponse = configService.createCategory(categoryRequest);
      LOGGER.info("create category with: "+ categoryResponse.toString());
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(),
        ResponseMessageConstants.CREATE_CATEGORY_SUCCESS);
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

  @GetMapping("/list-product-by-category")
  ResponseData getListProductByCategory(@RequestParam(value = "categoryId", required = false) Long categoryId) {
    try {
      List<Product> productList = productService.getListProductByCategoryId(categoryId);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS, productList);
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    }
  }
}
