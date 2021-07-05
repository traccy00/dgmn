package com.traccy.dgmn.model.request;

import com.traccy.dgmn.entity.Image;
import com.traccy.dgmn.entity.Product;

import java.util.List;

public class ProductCreateRequest {
  private Product product;
  private List<Image> imageList;

  public ProductCreateRequest() {
  }

  public ProductCreateRequest(Product product, List<Image> imageList) {
    this.product = product;
    this.imageList = imageList;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public List<Image> getImageList() {
    return imageList;
  }

  public void setImageList(List<Image> imageList) {
    this.imageList = imageList;
  }
}
