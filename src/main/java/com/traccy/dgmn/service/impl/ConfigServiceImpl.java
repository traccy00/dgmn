package com.traccy.dgmn.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traccy.dgmn.config.constant.ActivityActionConstants;
import com.traccy.dgmn.config.constant.ProductConstant;
import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.entity.Category;
import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.entity.Unit;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.request.CategoryRequest;
import com.traccy.dgmn.model.request.ImageRequest;
import com.traccy.dgmn.model.request.UnitRequest;
import com.traccy.dgmn.model.response.CategoryResponse;
import com.traccy.dgmn.repository.ImageRepository;
import com.traccy.dgmn.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

  @Autowired
  private ImageService imageService;

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private UnitService unitService;

  @Autowired
  private ProductService productService;

  @Autowired
  private ActivityService activityService;

  @Autowired
  private ImageRepository imageRepository;

  @Override
  public void createCategory(CategoryRequest categoryRequest) throws Exception {
    //validate input name
    if (StringUtils.isEmpty(categoryRequest.getName().trim()) || categoryRequest.getName() == null) {
      throw new BusinessException(ResponseMessageConstants.CATEGORY_NAME_NOT_BLANK);
    }
    //check category existed
    Category category = categoryService.getCategoryByName(categoryRequest.getName());
    if (category != null) {
      throw new BusinessException(ResponseMessageConstants.CATEGORY_EXIST);
    }
    String beforeData = new ObjectMapper().writeValueAsString(null);
    category = new Category();
    category.setName(categoryRequest.getName());
    category.setDescription(categoryRequest.getDescription());
    category.setSubcategory(categoryRequest.isSubcategory());
    category.setParentCategoryId(categoryRequest.getParentCategoryId());
    category.setStatus(true);
    category.create();
    //save category
    Category categorySave = categoryService.saveCategory(category);
    activityService.logActivityData(ActivityActionConstants.CREATE_CATEGORY, beforeData,
      new ObjectMapper().writeValueAsString(categorySave));
  }

  @Override
  public void saveImagesOfProduct(List<String> imageNameList, long productId) throws Exception {
    //check product exist
    Product product = productService.getById(productId);
    if (product == null) {
      throw new BusinessException(ResponseMessageConstants.PRODUCT_NOT_EXIST);
    }
    //check list image size
    if (imageNameList.size() > ProductConstant.QUANTITY_LIMIT_IMAGE) {
      throw new BusinessException(ResponseMessageConstants.IMAGE_QUANTITY_LIMIT);
    }
    List<Image> listImageSaved = new ArrayList<>();
    int count = 0;
    for (String imageName : imageNameList) {
      ImageRequest imageRequest = new ImageRequest();
      //first image
      if (count == 0) {
        imageRequest.setAvatar(true);
        count++;
      }
      imageRequest.setProductId(productId);
      imageRequest.setName(imageName);
      Image imageInfor = imageService.imageInfor(imageRequest);
      if (imageInfor == null) {
        throw new BusinessException(ResponseMessageConstants.CANNOT_SAVE_IMAGE);
      }
      Image image = imageRepository.save(imageInfor);
      listImageSaved.add(imageInfor);
      //save log activity
      String beforeData = new ObjectMapper().writeValueAsString(null);
      activityService.logActivityData(ActivityActionConstants.CREATE_IMAGE, beforeData,
        new ObjectMapper().writeValueAsString(image));
    }
  }

  @Override
  public void createUnit(UnitRequest unitRequest) throws Exception {
    if (StringUtils.isBlank(unitRequest.getName().trim())) {
      throw new BusinessException(ResponseMessageConstants.UNIT_NAME_NOT_BLANK);
    }
    String beforeData = new ObjectMapper().writeValueAsString(null);
    Unit unit = unitService.getUnitByName(unitRequest.getName());
    if (unit != null) {
      throw new BusinessException(ResponseMessageConstants.UNIT_EXIST);
    }
    unit = new Unit();
    unit.setName(unitRequest.getName());
    unit.setDescription(unitRequest.getDescription());
    unit.setStatus(true);
    unit.create();
    Unit unit1 = unitService.saveUnit(unit);
    activityService
      .logActivityData(ActivityActionConstants.CREATE_UNIT, beforeData, new ObjectMapper().writeValueAsString(unit1));
  }
}
