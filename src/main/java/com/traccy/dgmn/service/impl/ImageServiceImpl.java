package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.model.request.ImageRequest;
import com.traccy.dgmn.repository.ImageRepository;
import com.traccy.dgmn.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
  @Autowired
  private ImageRepository imageRepository;

  @Override
  public Image imageInfor(ImageRequest imageRequest) {
    Image image = new Image();
    image.setName(imageRequest.getName());
    image.setProductId(imageRequest.getProductId());
    image.setAvatar(imageRequest.isAvatar());
    image.setStatus(true);
    image.create();
    return image;
  }

  @Override
  public Image getAvatarOfProduct(long productId) {
    return imageRepository.getAvatar(productId);
  }

  @Override
  public List<Image> getOptionalImageList(long productId) {
    return imageRepository.getOptionalImage(productId);
  }
}
