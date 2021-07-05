package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.model.request.CategoryRequest;
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
  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public boolean checkExistById(long categoryId) {
    return categoryRepository.existsById(categoryId);
  }
}
