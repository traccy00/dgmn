package com.traccy.dgmn.model.response;

import java.util.List;

public class ShopInformationResponse {
  private long id;
  private String name;
  private String address;
  private String[] phoneNumber;

  public ShopInformationResponse() {
  }

  public ShopInformationResponse(long id, String name, String address, String[] phoneNumber) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String[] getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String[] phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
