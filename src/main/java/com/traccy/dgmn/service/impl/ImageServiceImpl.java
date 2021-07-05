package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.repository.ImageRepository;
import com.traccy.dgmn.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
  @Autowired
  private ImageRepository imageRepository;

  @Override
  public Image saveImage(Image image) {
    return imageRepository.save(image);
  }
}
