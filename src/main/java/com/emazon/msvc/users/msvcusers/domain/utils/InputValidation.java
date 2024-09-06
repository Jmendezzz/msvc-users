package com.emazon.msvc.users.msvcusers.domain.utils;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.UserValidationConstant.*;

public class InputValidation {
  public static boolean isNullOrEmpty(String input) {
    return input == null || input.isEmpty() || input.isBlank();
  }
  public static boolean isNull(Object input) {
    return input == null;
  }
  public static boolean isEmailValid(String email) {
    return email.matches(EMAIL_VALIDATION_REGEX);
  }
  public static boolean isPasswordValid(String password) {
    return password.matches(PASSWORD_VALIDATION_REGEX);
  }
  public static boolean isPhoneNumberValid(String phoneNumber) {
    if(phoneNumber.length() > PHONE_NUMBER_MAX_LENGTH) {
      return false;
    }

    return phoneNumber.startsWith(PHONE_PREFIX);
  }
  private InputValidation() {
  }
}
