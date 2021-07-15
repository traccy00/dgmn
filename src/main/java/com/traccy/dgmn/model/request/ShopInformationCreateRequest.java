package com.traccy.dgmn.model.request;

import java.util.List;

public class ShopInformationCreateRequest {
  private String name;
  private String address;
  private List<String> phoneNumberList;

  public ShopInformationCreateRequest() {
  }

  public ShopInformationCreateRequest(String name, String address, List<String> phoneNumberList) {
    this.name = name;
    this.address = address;
    this.phoneNumberList = this.phoneNumberList;
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

  public List<String> getPhoneNumberList() {
    return phoneNumberList;
  }

  public void setPhoneNumberList(List<String> phoneNumberList) {
    this.phoneNumberList = phoneNumberList;
  }

  @Override
  public String toString() {
    return "ShopInformationCreateRequest{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", phoneNumberList=" + phoneNumberList + '}';
  }
}

