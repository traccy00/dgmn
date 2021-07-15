package com.traccy.dgmn.entity;

import com.traccy.dgmn.config.model.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activities")
public class Activity extends BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "ip_address")
  private String ipAddress;

  @Column(name = "action")
  private String action;

  @Column(name = "beforeData")
  private String beforeData;

  @Column(name = "afterData")
  private String afterData;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getBeforeData() {
    return beforeData;
  }

  public void setBeforeData(String beforeData) {
    this.beforeData = beforeData;
  }

  public String getAfterData() {
    return afterData;
  }

  public void setAfterData(String afterData) {
    this.afterData = afterData;
  }
}
