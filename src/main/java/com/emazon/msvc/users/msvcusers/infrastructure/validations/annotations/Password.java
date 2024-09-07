package com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.validators.PasswordValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default UserExceptionMessage.USER_PASSWORD_INVALID_FORMAT;
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
