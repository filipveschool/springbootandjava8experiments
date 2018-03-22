package com.filip.springbootandjava8experiments.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.filip.springbootandjava8experiments.models.Role;
import com.filip.springbootandjava8experiments.validation.annotation.PasswordMatches;
import com.filip.springbootandjava8experiments.validation.annotation.ValidEmail;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//http://www.baeldung.com/registration-with-spring-mvc-and-spring-security
@PasswordMatches
@JsonIgnoreProperties(value = {"password", "passwordConfirmation"}, allowSetters = true)
public class UserDto {

  private Long id;

  @NotNull
  @Size(min = 3, max = 50)
  private String username;

  @NotNull
  @NotEmpty
  @ValidEmail
  private String email;

  @NotNull
  @Size(min = 3)
  private String password;

  private String passwordConfirmation;

  @NotNull
  @NotEmpty
  private String firstName;

  @NotNull
  @NotEmpty
  private String lastName;

  private Boolean active;

  private Set<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
