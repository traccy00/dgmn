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

  @Column(name = "purchased_product")
  private String purchasedProductName;

  @Column(name = "comment")
  private String comment;

  public Evaluate() {
  }

  public Evaluate(long id, String fullName, String address, String purchasedProductName, String comment) {
    this.id = id;
    this.fullName = fullName;
    this.address = address;
    this.purchasedProductName = purchasedProductName;
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

  public String getPurchasedProductName() {
    return purchasedProductName;
  }

  public void setPurchasedProductName(String purchasedProductName) {
    this.purchasedProductName = purchasedProductName;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
