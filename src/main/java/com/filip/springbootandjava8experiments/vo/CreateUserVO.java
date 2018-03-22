package com.filip.springbootandjava8experiments.vo;

import com.filip.springbootandjava8experiments.validation.annotation.Username;
import javax.validation.constraints.NotNull;

/**
 * CreateUserVO – use for getting user info when creating it.
 */
public class CreateUserVO {

  @NotNull(message = "first name can not be null.")
  private String firstName;

  @NotNull(message = "last name can not be null.")
  private String lastName;

  @Username(message = "Invalid username.")
  private String username;

  private String password;

  private String passwordConfirmation;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirmation() {
    return passwordConfirmation;
  }

  public void setPasswordConfirmation(String passwordConfirmation) {
    this.passwordConfirmation = passwordConfirmation;
  }
}
