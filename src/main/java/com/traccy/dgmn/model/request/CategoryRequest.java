package com.traccy.dgmn.model.request;

public class CategoryRequest {
  private String name;
  private String description;
  private boolean isSubcategory;
  private long parentCategoryId;

  public CategoryRequest() {
  }

  public CategoryRequest(String name, String description, boolean isSubcategory, long parentCategoryId) {
    this.name = name;
    this.description = description;
    this.isSubcategory = isSubcategory;
    this.parentCategoryId = parentCategoryId;
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

  public boolean isSubcategory() {
    return isSubcategory;
  }

  public void setSubcategory(boolean subcategory) {
    isSubcategory = subcategory;
  }

  public long getParentCategoryId() {
    return parentCategoryId;
  }

  public void setParentCategoryId(long parentCategoryId) {
    this.parentCategoryId = parentCategoryId;
  }

  @Override
  public String toString() {
    return "CategoryRequest{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", isSubcategory=" + isSubcategory + ", parentCategoryId=" + parentCategoryId + '}';
  }
}
