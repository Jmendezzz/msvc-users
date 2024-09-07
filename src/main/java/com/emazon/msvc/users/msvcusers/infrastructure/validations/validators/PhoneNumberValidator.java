package com.emazon.msvc.users.msvcusers.infrastructure.validations.validators;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserValidationConstant;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
  private String prefix;

  @Override
  public void initialize(PhoneNumber constraintAnnotation) {
    this.prefix = constraintAnnotation.prefix();
  }

  @Override
  public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
    return phoneNumber.startsWith(prefix) && phoneNumber.length()  <= UserValidationConstant.PHONE_NUMBER_MAX_LENGTH;
  }


}


