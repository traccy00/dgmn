package com.traccy.dgmn.entity;

import com.traccy.dgmn.config.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private long id;

  @Column(name = "group_name")
  private String groupName;

  @Column(name = "name")
  private String name;

  @Column(name = "quantity")
  private long quantity;

  @Column(name = "price")
  private long price;

  @Column(name = "is_leaf")
  private boolean isLeaf;

  @Column(name = "parent_id")
  private long parentId;

  @Column(name = "product_id")
  private long productId;

  public Option() {
  }

  public Option(long id, String groupName, String name, long quantity, long price, boolean isLeaf, long parentId,
    long productId) {
    this.id = id;
    this.groupName = groupName;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.isLeaf = isLeaf;
    this.parentId = parentId;
    this.productId = productId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public boolean isLeaf() {
    return isLeaf;
  }

  public void setLeaf(boolean leaf) {
    isLeaf = leaf;
  }

  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }
}
