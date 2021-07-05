package com.traccy.dgmn.entity;

import com.traccy.dgmn.config.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "product_id")
  private long productId;

  @Column(name = "evaluate_id")
  private long evaluateId;

  @Column(name = "is_avatar")
  private boolean isAvatar;

  public Image() {
  }

  public Image(long id, String name, long productId, long evaluateId, boolean isAvatar) {
    this.id = id;
    this.name = name;
    this.productId = productId;
    this.evaluateId = evaluateId;
    this.isAvatar = isAvatar;
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

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public long getEvaluateId() {
    return evaluateId;
  }

  public void setEvaluateId(long evaluateId) {
    this.evaluateId = evaluateId;
  }

  public boolean isAvatar() {
    return isAvatar;
  }

  public void setAvatar(boolean avatar) {
    isAvatar = avatar;
  }
}
