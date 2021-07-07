package com.traccy.dgmn.model.request;

import com.traccy.dgmn.model.dto.ProductInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

//@ApiModel(description = "")
public class ProductCreateRequest {
  //  @ApiModelProperty(notes = "")
  private long productId;
  private ProductInformation productInformation;
  private List<String> imageList;

  public ProductCreateRequest() {
  }

  public ProductCreateRequest(long productId, ProductInformation product, List<String> imageList) {
    this.productId = productId;
    this.productInformation = product;
    this.imageList = imageList;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public ProductInformation getProductInformation() {
    return productInformation;
  }

  public void setProductInformation(ProductInformation productInformation) {
    this.productInformation = productInformation;
  }

  public List<String> getImageList() {
    return imageList;
  }

  public void setImageList(List<String> imageList) {
    this.imageList = imageList;
  }

  @Override
  public String toString() {
    return "ProductCreateRequest{productInformation=" + productInformation + ", imageList=" + imageList + '}';
  }
}
