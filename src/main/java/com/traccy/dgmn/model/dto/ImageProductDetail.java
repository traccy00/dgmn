package com.traccy.dgmn.model.dto;

import com.traccy.dgmn.entity.Image;

import java.util.List;

public class ImageProductDetail {
  private Image avatar;
  private List<Image> optionalImage;
  private List<Image> descriptionImage;

  public Image getAvatar() {
    return avatar;
  }

  public void setAvatar(Image avatar) {
    this.avatar = avatar;
  }

  public List<Image> getOptionalImage() {
    return optionalImage;
  }

  public void setOptionalImage(List<Image> optionalImage) {
    this.optionalImage = optionalImage;
  }

  public List<Image> getDescriptionImage() {
    return descriptionImage;
  }

  public void setDescriptionImage(List<Image> descriptionImage) {
    this.descriptionImage = descriptionImage;
  }
}
