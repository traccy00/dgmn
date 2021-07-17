package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.exception.BusinessException;

public interface CategoryService {

  Category getCategoryByName(String name);

  Category saveCategory(Category category) throws BusinessException;

  Category getSubCategoryById(long id);

  Category getCategoryById(long id);

  boolean checkExistById(long categoryId);
}
