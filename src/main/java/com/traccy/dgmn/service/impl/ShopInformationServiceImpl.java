package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.config.constant.ResponseMessageConstants;
import com.traccy.dgmn.config.model.Mapper;
import com.traccy.dgmn.entity.ShopInformation;
import com.traccy.dgmn.exception.BusinessException;
import com.traccy.dgmn.model.response.ShopInformationResponse;
import com.traccy.dgmn.repository.ShopInforRepository;
import com.traccy.dgmn.service.ShopInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopInformationServiceImpl implements ShopInformationService {

  @Autowired
  private ShopInforRepository shopInforRepository;

  @Override
  public ShopInformationResponse getShopInformation() throws BusinessException {
    ShopInformation defaultShopInformation = shopInforRepository.getDefaultShopInformation();
    if (defaultShopInformation == null) {
      throw new BusinessException(ResponseMessageConstants.SHOP_INFORMATION_NOT_EXIST);
    }
    String phoneNumberList = defaultShopInformation.getPhoneNumber();
    String[] phoneNumber = phoneNumberList.split(",");
    ShopInformationResponse response = new ShopInformationResponse();
    response.setPhoneNumber(phoneNumber);
    response = Mapper.copyFrom(defaultShopInformation, ShopInformationResponse.class);
    return response;
  }

  @Override
  public ShopInformation saveShopInformation(ShopInformation shopInformation) {
    return shopInforRepository.save(shopInformation);
  }

  @Override
  public int getNumberOfShop() {
    return shopInforRepository.countNumberOfShop();
  }

}
