package com.filip.springbootandjava8experiments.vo;

/**
 * UpdateUserVO – use for getting user info when updating it.
 */
public class UpdateUserVO {
  private Long userId;
  private String firstName;
  private String lastName;
  private String username;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
