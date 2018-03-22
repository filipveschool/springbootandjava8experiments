package com.filip.springbootandjava8experiments.utils;

/**
 * Create private constructor to avoid create multiple instance.
 *
 * All methods must be static.
 *
 * Should not call other Services, Assemblers, Controllers, Repositories.
 */
public class UserUtil {

  private UserUtil() {

  }

  public static String convertToFullName(String firstName, String lastName) {
    return firstName + " " + lastName;
  }

}
