package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.ShopInformationCreateRequest;
import com.traccy.dgmn.model.response.ShopInformationResponse;
import com.traccy.dgmn.service.AdminProductService;
import com.traccy.dgmn.service.ShopInformationService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/information")
public class ShopInformationController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ShopInformationController.class);
  @Autowired
  private ShopInformationService shopInformationService;

  @Autowired
  private AdminProductService adminProductService;

  @PostMapping("/create-shop-information")
  @ApiOperation(value = "create shop information")
  ResponseData createShopInformation(@RequestBody ShopInformationCreateRequest request) {
    try {
      LOGGER.info("create shop info with {}", request);
      adminProductService.createShopInformation(request);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(),
        ResponseMessageConstants.CREATE_SHOP_INFORMATION_SUCCESS);
    } catch (BusinessException e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

  @GetMapping("/get-default-shop-information")
  @ApiOperation(value = "get information of shop")
  ResponseData getShopInformation() {
    try {
      ShopInformationResponse information = shopInformationService.getShopInformation();
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS, information);
    } catch (BusinessException e) {
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    } catch (Exception e) {
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

//  @PutMapping("/change-default-shop-information")
//  @ApiOperation(value = "")
//  ResponseData changeDefaultShopInformation() {
//    try {
//      adminProductService.changeDefaultShopInformation();
//      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS);
//    } catch (Exception e) {
//      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
//    }
//  }
}
