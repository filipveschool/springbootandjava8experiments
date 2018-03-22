package com.filip.springbootandjava8experiments.errors;

import com.filip.springbootandjava8experiments.exceptions.ResourceNotFoundException;
import com.filip.springbootandjava8experiments.utils.ValidationUtil;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

  @ExceptionHandler({ResourceNotFoundException.class})
  public ResponseEntity<ApiError> resourceNotFound(ResourceNotFoundException ex) {
    ApiError response = new ApiError();
    response.setErrorCode("Not Found");
    response.setErrorMessage(ex.getMessage());

    return new ResponseEntity<ApiError>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> invalidInput(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    ApiError response = new ApiError();
    response.setErrorCode("Validation Error");
    //response.setMessage(ex.getMessage());
    response.setErrorMessage("Invalid inputs.");
    response.setErrors(ValidationUtil.fromBindingErrors(result));
    return new ResponseEntity<ApiError>(response, HttpStatus.BAD_REQUEST);
  }

}
