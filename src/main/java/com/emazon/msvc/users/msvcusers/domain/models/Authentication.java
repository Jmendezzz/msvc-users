package com.emazon.msvc.users.msvcusers.domain.models;

public class Authentication {
  private User user;
  private String token;

  public Authentication(User user, String token) {
    this.user = user;
    this.token = token;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
