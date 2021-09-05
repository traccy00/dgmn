package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.request.UnitRequest;
import com.traccy.dgmn.model.response.CategoryResponse;
import com.traccy.dgmn.service.CategoryService;
import com.traccy.dgmn.service.ConfigService;
import io.swagger.annotations.ApiOperation;
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
  private ConfigService configService;

  @Autowired
  private CategoryService categoryService;

  @PostMapping("/create-category")
  ResponseData createCategory(@RequestBody CategoryRequest categoryRequest) {
    try {
      //check when user not input anything
      if(categoryRequest == null) {
        return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.DATA_INVALID);
      }
      LOGGER.info("create category with: " + categoryRequest.toString());
      configService.createCategory(categoryRequest);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(),
        ResponseMessageConstants.CREATE_CATEGORY_SUCCESS);
    } catch (BusinessException e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

  @PostMapping("create-unit")
  ResponseData createUnit(@RequestBody UnitRequest unitRequest) {
    try {
      //check when user not input anything
      if(unitRequest == null) {
        return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.DATA_INVALID);
      }
      LOGGER.info("create unit with: {}", unitRequest.toString());
      configService.createUnit(unitRequest);
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS);
    } catch (BusinessException e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), e.getMessage());
    } catch (Exception e) {
      LOGGER.error(LogUtils.printLogStackTrace(e));
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

  @ApiOperation(value = "API get list subcategory", notes = "")
  @GetMapping("/get-list-sub-category")
  ResponseData getListSubcategory() {
    try {
      List<CategoryResponse> categoryResponseList = configService.getListAllSubcategory();
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS,
        categoryResponseList);
    } catch (Exception e) {
      String msg = LogUtils.printLogStackTrace(e);
      LOGGER.error(msg);
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }

  @ApiOperation(value = "API get list parent category",
    notes = "list parent category for phòng bếp, phòng khách, phòng ngủ")
  @GetMapping("/get-list-parent-category")
  ResponseData getListParentCategory() {
    try {
      List<CategoryResponse> categoryResponseList = configService.getListAllParentCategory();
      return new ResponseData(Enums.ResponseStatus.SUCCESS.getStatus(), ResponseMessageConstants.SUCCESS,
        categoryResponseList);
    } catch (Exception e) {
      String msg = LogUtils.printLogStackTrace(e);
      LOGGER.error(msg);
      return new ResponseData(Enums.ResponseStatus.ERROR.getStatus(), ResponseMessageConstants.ERROR);
    }
  }
}
