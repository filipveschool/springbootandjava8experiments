package com.filip.springbootandjava8experiments.validation.validator;

import com.filip.springbootandjava8experiments.models.User;
import com.filip.springbootandjava8experiments.validation.annotation.PasswordMatches;
import com.filip.springbootandjava8experiments.vo.CreateUserVO;
import com.filip.springbootandjava8experiments.vo.UserVO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements
    ConstraintValidator<PasswordMatches, CreateUserVO> {

  @Override
  public void initialize(final PasswordMatches annotation) {
  }

  @Override
  public boolean isValid(CreateUserVO userDto, ConstraintValidatorContext context) {
    return userDto.getPassword() != null && userDto.getPassword()
        .equals(userDto.getPasswordConfirmation());
  }
}
