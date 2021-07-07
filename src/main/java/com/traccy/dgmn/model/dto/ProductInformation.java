package com.traccy.dgmn.model.dto;

public class ProductInformation {
  private String name;
  private String description;
  private long categoryId;
  private long unitId;

  public ProductInformation() {
  }

  public ProductInformation(String name, String description, long categoryId, long unitId) {
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.unitId = unitId;
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
    return "ProductInformation{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", categoryId=" + categoryId + ", unitId=" + unitId + '}';
  }
}
