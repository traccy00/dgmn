package com.traccy.dgmn.model.response;

public class CategoryResponse {
  private long id;
  private String name;
  private String description;
  private boolean status;
  private long createdAt;
  private long updatedAt;

  public CategoryResponse() {
  }

  public CategoryResponse(long id, String name, String description, boolean status, long createdAt, long updatedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(long createdAt) {
    this.createdAt = createdAt;
  }

  public long getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public String toString() {
    return "CategoryResponse{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
  }

  public void setUpdatedAt(long updatedAt) {
    this.updatedAt = updatedAt;
  }
}
