package com.filip.springbootandjava8experiments.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  private Long resourceId;

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(Long resourceId, String message) {
    super(message);
    this.resourceId = resourceId;
  }
}