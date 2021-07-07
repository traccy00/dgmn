package com.traccy.dgmn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.request.UnitRequest;
import com.traccy.dgmn.model.response.CategoryResponse;

import java.util.List;

public interface ConfigService {

  CategoryResponse createCategory(CategoryRequest categoryRequest) throws BusinessException;

  void saveImagesOfProduct(List<String> imageList, long productId) throws Exception;

  void createUnit(UnitRequest unitRequest) throws BusinessException;
}
