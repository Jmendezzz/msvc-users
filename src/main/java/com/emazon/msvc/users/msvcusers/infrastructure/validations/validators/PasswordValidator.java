package com.emazon.msvc.users.msvcusers.infrastructure.validations.validators;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserValidationConstant;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.matches(UserValidationConstant.PASSWORD_VALIDATION_REGEX);
  }
}
