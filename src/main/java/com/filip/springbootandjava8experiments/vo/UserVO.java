package com.filip.springbootandjava8experiments.vo;

/**
 * UserVO – use for returning user info.
 */
public class UserVO {

  private Long userId;
  private String fullName;
  private String username;
  //getters and setters


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
