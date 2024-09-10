package com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserValidationConstant;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.validators.AgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AgeValidator.class)
public @interface MinAge {
  String message() default UserExceptionMessage.USER_MIN_AGE;
  int value() default UserValidationConstant.MIN_AGE;

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}