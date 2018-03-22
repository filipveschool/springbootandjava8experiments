package com.filip.springbootandjava8experiments.validation.validator;

import com.filip.springbootandjava8experiments.validation.annotation.Username;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

  public void initialize(Username constraint) {
  }

  public boolean isValid(String value, ConstraintValidatorContext context) {

    if ("filip".equalsIgnoreCase(value)) {
      return false;
    }
    return true;
  }

}
