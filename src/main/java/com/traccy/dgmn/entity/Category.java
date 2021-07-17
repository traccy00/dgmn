package com.traccy.dgmn.entity;

import com.traccy.dgmn.config.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "is_subcategory")
  private boolean isSubcategory;

  @Column(name = "parent_category_id")
  private long parentCategoryId;

  public Category() {
  }

  public Category(long id, String name, String description, boolean isSubcategory, long parentCategoryId) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.isSubcategory = isSubcategory;
    this.parentCategoryId = parentCategoryId;
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
    return "Category{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", isSubcategory=" + isSubcategory + ", parentCategoryId=" + parentCategoryId + '}';
  }
}
