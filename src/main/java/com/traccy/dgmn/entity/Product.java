package com.traccy.dgmn.entity;

import com.traccy.dgmn.config.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "category_id")
  private long categoryId;

  @Column(name = "unit_id")
  private long unitId;

  @Column(name = "price")
  private long price;

  @Column(name = "material")
  private String material;

  @Column(name = "size")
  private String size;

  @Column(name = "warranty")
  private String warranty;

  @Column(name = "shipping_fee")
  private String shippingFee;

  @Column(name = "stocking")
  private String stocking;

  public Product() {
  }

  public Product(long id, String name, String description, long categoryId, long unitId, long price, String material,
    String size, String warranty, String shippingFee, String stocking) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.unitId = unitId;
    this.price = price;
    this.material = material;
    this.size = size;
    this.warranty = warranty;
    this.shippingFee = shippingFee;
    this.stocking = stocking;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
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

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", categoryId=" + categoryId + ", unitId=" + unitId + ", price=" + price + ", material='" + material + '\'' + ", size='" + size + '\'' + ", warranty='" + warranty + '\'' + ", shippingFee='" + shippingFee + '\'' + ", stocking='" + stocking + '\'' + '}';
  }
}
