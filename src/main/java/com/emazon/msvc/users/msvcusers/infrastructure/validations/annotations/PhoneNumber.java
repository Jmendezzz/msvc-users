package com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserValidationConstant;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.validators.PhoneNumberValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {
    String message() default UserExceptionMessage.USER_PHONE_NUMBER_INVALID;
    String prefix() default UserValidationConstant.PHONE_PREFIX;

    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
