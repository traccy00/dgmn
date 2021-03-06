package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.exception.BusinessException;

import java.util.List;

public interface CategoryService {

  Category getCategoryByName(String name);

  Category saveCategory(Category category) throws BusinessException;

  Category getSubCategoryById(long id);

  Category getCategoryById(long id);

  List<Long> getListIdByParentCategoryId(long parentCategoryId);

  boolean checkExistById(long categoryId);

  List<Category> getAllSubcategory();

  List<Category> getAllParentcategory();
}
