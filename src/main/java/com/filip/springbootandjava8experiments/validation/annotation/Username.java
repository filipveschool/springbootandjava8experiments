package com.filip.springbootandjava8experiments.validation.annotation;

import com.filip.springbootandjava8experiments.validation.validator.UsernameValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {

  String message() default "{Username}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
