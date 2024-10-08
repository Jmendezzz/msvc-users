package com.emazon.msvc.users.msvcusers.domain.models;

public class Role {
  private Long id;
  private String name;
  private String description;

  public Role(Long id, String name, String description) {
    setId(id);
    setName(name);
    setDescription(description);
  }
  public Role() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
}
