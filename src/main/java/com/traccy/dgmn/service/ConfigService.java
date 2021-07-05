package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.response.CategoryResponse;

import java.util.List;

public interface ConfigService {
  CategoryResponse createCategory(CategoryRequest categoryRequest) throws BusinessException;

  void saveImageProduct(List<Image> imageList, long productId);
}
