package com.traccy.dgmn.controller;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.enums.Enums;
import com.traccy.dgmn.config.util.LogUtils;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.ResponseData;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.request.UnitRequest;
import com.traccy.dgmn.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/config")
public class ConfigController {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);

  @Autowired
  private ConfigService configService;

  @PostMapping("/create-category")
  ResponseData createCategory(@RequestBody CategoryRequest categoryRequest) {
    try {
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
}
