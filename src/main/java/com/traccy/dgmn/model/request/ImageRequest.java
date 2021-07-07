package com.traccy.dgmn.model.request;

public class ImageRequest {
  private long id;
  private long productId;
  private String name;
  private boolean isAvatar;

  public ImageRequest() {
  }

  public ImageRequest(long id, long productId, String name, boolean isAvatar) {
    this.id = id;
    this.productId = productId;
    this.name = name;
    this.isAvatar = isAvatar;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isAvatar() {
    return isAvatar;
  }

  public void setAvatar(boolean avatar) {
    isAvatar = avatar;
  }
}
