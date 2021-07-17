package com.traccy.dgmn.model.dto;

public class ProductInformation {
  private String name;
  private String description;
  private long categoryId;
  private long unitId;
  private long price;
  private String size;
  private String warranty;
  private String shippingFee;
  private String stocking;

  public ProductInformation() {
  }

  public ProductInformation(String name, String description, long categoryId, long unitId, long price, String size,
    String warranty, String shippingFee, String stocking) {
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.unitId = unitId;
    this.price = price;
    this.size = size;
    this.warranty = warranty;
    this.shippingFee = shippingFee;
    this.stocking = stocking;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getWarranty() {
    return warranty;
  }

  public void setWarranty(String warranty) {
    this.warranty = warranty;
  }

  public String getShippingFee() {
    return shippingFee;
  }

  public void setShippingFee(String shippingFee) {
    this.shippingFee = shippingFee;
  }

  public String getStocking() {
    return stocking;
  }

  public void setStocking(String stocking) {
    this.stocking = stocking;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }

  public long getUnitId() {
    return unitId;
  }

  public void setUnitId(long unitId) {
    this.unitId = unitId;
  }

  @Override
  public String toString() {
    return "ProductInformation{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", categoryId=" + categoryId + ", unitId=" + unitId + ", size='" + size + '\'' + ", warranty='" + warranty + '\'' + ", shippingFee='" + shippingFee + '\'' + ", stocking='" + stocking + '\'' + '}';
  }
}
