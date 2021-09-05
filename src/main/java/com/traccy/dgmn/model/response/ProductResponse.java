package com.traccy.dgmn.model.response;

public class ProductResponse {
  private long id;
  private String name;
  private long categoryId;
  private long unitId;
  private long price;
  private long salePrice;
  private String material;
  private String size;

  public ProductResponse() {
  }

  public ProductResponse(long id, String name, long categoryId, long unitId, long price, long salePrice,
    String material, String size) {
    this.id = id;
    this.name = name;
    this.categoryId = categoryId;
    this.unitId = unitId;
    this.price = price;
    this.salePrice = salePrice;
    this.material = material;
    this.size = size;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public long getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(long salePrice) {
    this.salePrice = salePrice;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }
}