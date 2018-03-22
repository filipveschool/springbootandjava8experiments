package com.filip.springbootandjava8experiments.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//https://www.toptal.com/java/spring-boot-rest-api-error-handling
public class ApiError {

  /**
   * The status property holds the operation call status. It will be anything from 4xx to signalize
   * client errors or 5xx to mean server errors. A common scenario is a http code 400 that means a
   * BAD_REQUEST, when the client, for example, sends an improperly formatted field, like an invalid
   * email address.
   */
  private HttpStatus status;

  /**
   * The timestamp property holds the date-time instance of when the error happened.
   */
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  /**
   * The errorMessage property holds a user-friendly errorMessage about the error.
   */
  private String errorMessage;

  /**
   * The debugMessage property holds a system errorMessage describing the error in more detail.
   */
  private String debugMessage;

  private String errorCode;

  private List<String> errors;

/*
  private List<ApiSubError> subErrors;
*/


  public ApiError() {
    timestamp = LocalDateTime.now();
    errors = new ArrayList<>();
  }

  public ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  public ApiError(HttpStatus status, Throwable ex) {
    this();
    this.status = status;
    this.errorMessage = "Unexpected error";
    this.debugMessage = ex.getLocalizedMessage();
  }

  public ApiError(HttpStatus status, String message, Throwable ex) {
    this();
    this.status = status;
    this.errorMessage = message;
    this.debugMessage = ex.getLocalizedMessage();
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }


  public String getDebugMessage() {
    return debugMessage;
  }

  public void setDebugMessage(String debugMessage) {
    this.debugMessage = debugMessage;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
