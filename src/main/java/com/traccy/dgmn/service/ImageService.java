package com.traccy.dgmn.service;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.model.request.ImageRequest;

public interface ImageService {

  Image imageInfor(ImageRequest imageRequest);
}
