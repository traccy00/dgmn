package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.response.CategoryResponse;

public interface CategoryService {

  Category getCategoryByName(String name);

  Category saveCategory(Category category);

  boolean checkExistById(long categoryId);
}
