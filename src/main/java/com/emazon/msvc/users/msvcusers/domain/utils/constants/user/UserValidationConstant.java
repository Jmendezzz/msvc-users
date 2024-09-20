package com.emazon.msvc.users.msvcusers.domain.utils.constants.user;

public class UserValidationConstant {
  public static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z\\d._%+-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,6}$";
  public static final String IDENTIFICATION_NUMBER_VALIDATION_REGEX = "\\d+";
  public static final String PASSWORD_VALIDATION_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_./])[A-Za-z\\d@$!%*?&_./]{8,}$";
  public static final int PHONE_NUMBER_MAX_LENGTH = 13;
  public static final String PHONE_PREFIX = "+57";
  public static final int MIN_AGE = 18;
  private UserValidationConstant() {
  }
}
