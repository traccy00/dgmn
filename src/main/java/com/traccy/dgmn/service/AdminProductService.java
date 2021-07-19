package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.model.request.ShopInformationCreateRequest;
import com.traccy.dgmn.model.response.ProductDetailResponse;

import java.util.List;

public interface AdminProductService {

  void createProduct(ProductCreateRequest productCreateRequest) throws Exception;

  Product createProductInformation(ProductInformation productInformation)
    throws Exception;

  void createShopInformation(ShopInformationCreateRequest request) throws Exception;

  ProductDetailResponse getProductDetail(long productId) throws BusinessException;

  List<ProductDetailResponse> getTop8DiscountProduct() throws BusinessException;

  List<ProductDetailResponse> getTop8NewestProduct() throws BusinessException;
}
