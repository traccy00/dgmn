package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.model.dto.ProductInformation;
import com.traccy.dgmn.model.request.ProductCreateRequest;
import com.traccy.dgmn.model.request.ShopInformationCreateRequest;

public interface AdminProductService {

  void createProduct(ProductCreateRequest productCreateRequest) throws Exception;

  Product createProductInformation(ProductInformation productInformation)
    throws Exception;

  void createShopInformation(ShopInformationCreateRequest request) throws Exception;

}
