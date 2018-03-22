package com.filip.springbootandjava8experiments.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ValidationUtil {

  public static List<String> fromBindingErrors(Errors errors) {
   /* List<String> validErrors = new ArrayList<String>();
    for (ObjectError objectError : errors.getAllErrors()) {
      validErrors.add(objectError.getDefaultMessage());
    }*/

    return errors.getAllErrors().stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
  }
}
