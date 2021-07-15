package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.service.AdminProductService;
import com.traccy.dgmn.service.ProductService;
import io.swagger.annotations.ApiOperation;
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

  @Autowired
  private ProductService productService;

  @ApiOperation(value = "Create product", notes = "provide product information and list image for it", response = ProductCreateRequest.class)
  @PostMapping("/create-product")
  ResponseData createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
    try {
      LOGGER.info("create product with {}", productCreateRequest);
      adminProductService.createProduct(productCreateRequest);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(),
        ResponseMessageConstants.CREATE_PRODUCT_SUCCESS);
    } catch (BusinessException e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

  @GetMapping("/get-list-product-by-category")
  @ApiOperation(value = "get list product by category", notes = "show product in category and show all", response = Product.class)
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
