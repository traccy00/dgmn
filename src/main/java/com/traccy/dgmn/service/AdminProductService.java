package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.request.ProductCreateRequest;

import java.util.List;

public interface AdminProductService {
  void createProduct(ProductCreateRequest productCreateRequest) throws BusinessException;

  Product createProductInformation(ProductCreateRequest productCreateRequest) throws BusinessException;

  void createImageListOfProduct(List<Image> imageList, long productId);
}
