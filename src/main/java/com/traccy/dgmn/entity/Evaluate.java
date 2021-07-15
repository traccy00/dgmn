package com.traccy.dgmn.entity;

import com.traccy.dgmn.config.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "evaluates")
public class Evaluate extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "address")
  private String address;

  @Column(name = "product_id")
  private long productId;

  @Column(name = "comment")
  private String comment;

  public Evaluate() {
  }

  public Evaluate(long id, String fullName, String address, long productId, String comment) {
    this.id = id;
    this.fullName = fullName;
    this.address = address;
    this.productId = productId;
    this.comment = comment;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
