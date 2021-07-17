package com.traccy.dgmn.config.enums;

public class Enums {
  public enum ResponseStatus {
    SUCCESS("Success"), ERROR("Error");

    ResponseStatus(String status) {
      this.status = status;
    }

    public String getStatus() {
      return status;
    }

    private String status;
  }

  public enum ShippingFee {
    Free("Miễn phí"), Contact("Thỏa thuận");

    ShippingFee(String status) {
      this.status = status;
    }

    public String getStatus() {
      return status;
    }

    private String status;
  }

  public enum StockingStatus {
    Stocking("Còn hàng"), Order("Đặt hàng");

    StockingStatus(String status) {this.status = status;}

    public String getStatus() {
      return status;
    }

    private String status;
  }
}
