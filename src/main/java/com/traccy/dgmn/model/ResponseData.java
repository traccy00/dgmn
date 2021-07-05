package com.traccy.dgmn.model;

import com.traccy.dgmn.config.enums.Enums;

public class ResponseData {
  protected Object data;
  protected String status;
  protected String message;
  protected String ex;

  public ResponseData() {
  }

  public ResponseData(Enums.ResponseStatus status, String message) {
    this.message = message;
    this.status = status.getStatus();
  }

  public ResponseData(String status, Object data) {
    this.status = status;
    this.data = data;
  }

  public ResponseData(String status, String message, Object data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }

  public ResponseData(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public ResponseData(Enums.ResponseStatus status, String message, Object data) {
    this.status = status.getStatus();
    this.message = message;
    this.data = data;
  }

  public ResponseData(Enums.ResponseStatus status, Object data) {
    this.status = status.getStatus();
    this.data = data;
  }

  public Object getData() {
    return data;
  }

  public ResponseData setData(Object data) {
    this.data = data;
    return this;
  }

  public String getStatus() {
    return status;
  }

  public ResponseData setStatus(String status) {
    this.status = status;
    return this;
  }

  public ResponseData setStatus(Enums.ResponseStatus status) {
    this.status = status.getStatus();
    return this;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getEx() {
    return ex;
  }

  public void setEx(String ex) {
    this.ex = ex;
  }
}
