package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.repository.CategoryRepository;
import com.traccy.dgmn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public Category getCategoryByName(String name) {
    return categoryRepository.findByName(name);
  }

  @Override
  public Category saveCategory(Category category) throws BusinessException {
    long categoryParentId = category.getParentCategoryId();
    if(categoryParentId != 0 && checkExistById(categoryParentId)) {
      return categoryRepository.save(category);
    }
    throw new BusinessException(ResponseMessageConstants.CATEGORY_NOT_EXIST);
  }

  @Override
  public Category getSubCategoryById(long id) {
    return categoryRepository.getSubcategoryById(id);
  }

  @Override
  public Category getCategoryById(long id) {
    return categoryRepository.findById(id);
  }

  @Override
  public boolean checkExistById(long categoryId) {
    return categoryRepository.existsById(categoryId);
  }
}
