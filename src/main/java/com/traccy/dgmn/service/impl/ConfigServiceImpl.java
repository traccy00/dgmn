package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.response.CategoryResponse;
import com.traccy.dgmn.repository.CategoryRepository;
import com.traccy.dgmn.service.CategoryService;
import com.traccy.dgmn.service.ConfigService;
import com.traccy.dgmn.service.ImageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

  @Autowired
  private ImageService imageService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public CategoryResponse createCategory(CategoryRequest categoryRequest) throws BusinessException {
    //validate input name
    if (StringUtils.isEmpty(categoryRequest.getName().trim()) || categoryRequest.getName() == null) {
      throw new BusinessException(ResponseMessageConstants.CATEGORY_NAME_NOT_BLANK);
    }
    //check category existed
    Category category = categoryService.getCategoryByName(categoryRequest.getName());
    if (category != null) {
      throw new BusinessException(ResponseMessageConstants.CATEGORY_EXIST);
    }
    category = new Category();
    category.setName(categoryRequest.getName());
    category.setDescription(categoryRequest.getDescription());
    category.setStatus(true);
    category.create();
    //save category
    categoryService.saveCategory(category);
    CategoryResponse categoryResponse = new CategoryResponse(category.getId(), category.getName(),
      category.getDescription(), category.isStatus(), category.getCreatedAt(), category.getUpdatedAt());
    return categoryResponse;
  }

  @Override
  public void saveImageProduct(List<Image> imageList, long productId) {
    for (Image image : imageList) {
      image.setProductId(productId);
      image.create();
      image.update();
      imageService.saveImage(image);
    }
  }
}
