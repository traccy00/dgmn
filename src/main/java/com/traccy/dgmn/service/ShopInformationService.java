package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.ShopInformation;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.response.ShopInformationResponse;

public interface ShopInformationService {

  ShopInformationResponse getShopInformation() throws BusinessException;

  ShopInformation saveShopInformation(ShopInformation shopInformation);

  int getNumberOfShop();
}
