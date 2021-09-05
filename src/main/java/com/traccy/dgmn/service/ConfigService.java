package com.traccy.dgmn.service;

import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.request.UnitRequest;
import com.traccy.dgmn.model.response.CategoryResponse;

import java.util.List;

public interface ConfigService {

  void createCategory(CategoryRequest categoryRequest) throws Exception;

  void saveImagesOfProduct(List<String> imageList, long productId) throws Exception;

  void createUnit(UnitRequest unitRequest) throws Exception;

  List<CategoryResponse> getListAllSubcategory();

  List<CategoryResponse> getListAllParentCategory();
}
