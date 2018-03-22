package com.filip.springbootandjava8experiments.validation.validator;

import com.filip.springbootandjava8experiments.validation.annotation.ContactNumberConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements
    ConstraintValidator<ContactNumberConstraint, String> {

  public void initialize(ContactNumberConstraint constraint) {
  }

  /**
   * The phone number must be a number with more than eight digits but no more that 11 digits.
   */
  public boolean isValid(String contactField, ConstraintValidatorContext context) {
    return contactField != null && contactField.matches("[0-9]+")
        && (contactField.length() > 8) && (contactField.length() < 14);
  }

}
