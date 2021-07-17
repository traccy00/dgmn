package com.traccy.dgmn.model.dto;

import com.traccy.dgmn.entity.Image;

import java.util.List;

public class ImageProductDetail {
  private Image avatar;
  private List<Image> optionalImageList;
//  private Image video;

  public ImageProductDetail() {
  }

  public ImageProductDetail(Image avatar, List<Image> optionalImageList) {
    this.avatar = avatar;
    this.optionalImageList = optionalImageList;
  }

//  public Image getVideo() {
//    return video;
//  }
//
//  public void setVideo(Image video) {
//    this.video = video;
//  }

  public Image getAvatar() {
    return avatar;
  }

  public void setAvatar(Image avatar) {
    this.avatar = avatar;
  }

  public List<Image> getOptionalImageList() {
    return optionalImageList;
  }

  public void setOptionalImageList(List<Image> optionalImageList) {
    this.optionalImageList = optionalImageList;
  }

}
