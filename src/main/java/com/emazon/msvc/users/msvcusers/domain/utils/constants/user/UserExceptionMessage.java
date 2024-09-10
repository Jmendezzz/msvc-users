package com.emazon.msvc.users.msvcusers.domain.utils.constants.user;

public class UserExceptionMessage {
  public static final String USER_FIRST_NAME_NULL_OR_EMPTY = "User first name cannot be null or empty";
  public static final String USER_LAST_NAME_NULL_OR_EMPTY = "User last name cannot be null or empty";
  public static final String USER_IDENTITY_NUMBER_NULL_OR_EMPTY = "User identity number cannot be null or empty";
  public static final String USER_PHONE_NUMBER_NULL_OR_EMPTY = "User phone number cannot be null or empty";
  public static final String USER_PHONE_NUMBER_INVALID = "User phone number is invalid";
  public static final String USER_BIRTH_DATE_NULL = "User birth date cannot be null";
  public static final String USER_MIN_AGE = "User must be at least 18 years old";
  public static final String USER_EMAIL_NULL_OR_EMPTY = "User email cannot be null or empty";
  public static final String USER_EMAIL_INVALID_FORMAT = "User email is invalid";
  public static final String USER_PASSWORD_NULL_OR_EMPTY = "User password cannot be null or empty";
  public static final String USER_PASSWORD_INVALID_FORMAT = "User password must contain at least one digit, one lowercase letter, one uppercase letter, one special character and must be at least 8 characters long";
  public static final String USER_ROLE_NULL = "User role cannot be null";
  public static final String USER_EMAIL_ALREADY_EXISTS = "The email has already been registered";
  public static final String USER_IDENTITY_NUMBER_ALREADY_EXISTS = "The identity number has already been registered";
  public static final String USER_PHONE_NUMBER_ALREADY_EXISTS = "The phone number has already been registered";
  private UserExceptionMessage() {
  }
}
