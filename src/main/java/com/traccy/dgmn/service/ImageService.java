package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.model.request.ImageRequest;

import java.util.List;

public interface ImageService {

  Image imageInfor(ImageRequest imageRequest);

  Image getAvatarOfProduct(long productId);

  List<Image> getOptionalImageList(long productId);
}
