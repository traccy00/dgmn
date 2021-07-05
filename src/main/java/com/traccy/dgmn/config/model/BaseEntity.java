package com.traccy.dgmn.config.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

  @Column(name = "status")
  private boolean status;

  @Column(name = "created_at")
  private long createdAt;

  @Column(name = "updated_at")
  private long updatedAt;

  public BaseEntity() {
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public BaseEntity setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  //  public void setCreatedAt(long createdAt) {
  //    this.createdAt = createdAt;
  //  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  public BaseEntity setUpdatedAt(long updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public BaseEntity create() {
    long time = System.currentTimeMillis();
    setCreatedAt(time);
    setUpdatedAt(time);
    return this;
  }

  public BaseEntity update() {
    long time = System.currentTimeMillis();
    setUpdatedAt(time);
    return this;
  }

}
