package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.model.response.ProductDetailResponse;
import com.traccy.dgmn.service.AdminProductService;
import com.traccy.dgmn.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

  @Autowired
  private AdminProductService adminProductService;

  @Autowired
  private ProductService productService;

  @ApiOperation(value = "Create product", notes = "provide product information and list image for it",
    response = ProductCreateRequest.class)
  @PostMapping("/create-product")
  ResponseData createProduct(@RequestBody ProductCreateRequest productCreateRequest) {
    try {
      if (productCreateRequest == null) {
        return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.DATA_INVALID);
      }
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

  @GetMapping("/get-list-product-by-subcategory")
  @ApiOperation(value = "get list product by category",
    notes = "show product in subcategory and show all in category pagination, more to see all of product in category",
    response = Product.class)
  ResponseData getListProductByCategory(@RequestParam(value = "parentCategoryId") long parentCategoryId,
    @RequestParam(value = "subcategoryId", required = false) Long subcategoryId) {
    try {
      List<Product> productList = productService.getListProductBySubcategoryId(parentCategoryId, subcategoryId);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS, productList);
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    }
  }

  @GetMapping("/get-product-detail")
  @ApiOperation(value = "get product detail when click to product information in Home page")
  ResponseData getProductDetail(@RequestParam(value = "productId") long productId) {
    try {
      if (productId <= 0) {
        return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.DATA_INVALID);
      }
      ProductDetailResponse detailResponse = adminProductService.getProductDetail(productId);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS,
        detailResponse);
    } catch (BusinessException e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }
}
