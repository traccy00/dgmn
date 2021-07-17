package com.traccy.dgmn.model.response;

import com.traccy.dgmn.model.dto.ImageProductDetail;

public class ProductDetailResponse {
  private ImageProductDetail imageProductDetail;
  private String productName;
  //for edit
  private long categoryId;
  private String categoryName;
  private long unitId;
  private String unitName;

  private String material;
  private String stockingStatus;
  private String warranty;
  private String size;
  private String shippingFee;

  public ImageProductDetail getImageProductDetail() {
    return imageProductDetail;
  }

  public void setImageProductDetail(ImageProductDetail imageProductDetail) {
    this.imageProductDetail = imageProductDetail;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
  }

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getStockingStatus() {
    return stockingStatus;
  }

  public void setStockingStatus(String stockingStatus) {
    this.stockingStatus = stockingStatus;
  }

  public String getWarranty() {
    return warranty;
  }

  public void setWarranty(String warranty) {
    this.warranty = warranty;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getShippingFee() {
    return shippingFee;
  }

  public void setShippingFee(String shippingFee) {
    this.shippingFee = shippingFee;
  }
}
