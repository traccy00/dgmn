package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Category;

public interface CategoryService {

  Category getCategoryByName(String name);

  Category saveCategory(Category category);

  boolean checkExistById(long categoryId);
}
