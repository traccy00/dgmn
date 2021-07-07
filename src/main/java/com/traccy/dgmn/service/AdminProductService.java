package com.traccy.dgmn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.traccy.dgmn.entity.Product;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.dto.ProductInformation;
import com.traccy.dgmn.model.request.ProductCreateRequest;

public interface AdminProductService {

  void createProduct(ProductCreateRequest productCreateRequest) throws Exception;

  Product createProductInformation(ProductInformation productInformation)
    throws Exception;
}
