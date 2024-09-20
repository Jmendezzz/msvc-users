package com.emazon.msvc.users.msvcusers.application.dtos.authentication;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserValidationConstant;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations.MinAge;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations.Password;
import com.emazon.msvc.users.msvcusers.infrastructure.validations.annotations.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage.*;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage.USER_PASSWORD_NULL_OR_EMPTY;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserValidationConstant.IDENTIFICATION_NUMBER_VALIDATION_REGEX;

public record SignUpRequestDto(
        @NotBlank(message = USER_FIRST_NAME_NULL_OR_EMPTY)
        String firstName,
        @NotBlank(message = USER_LAST_NAME_NULL_OR_EMPTY)
        String lastName,
        @NotBlank(message = USER_IDENTITY_NUMBER_NULL_OR_EMPTY)
        @Pattern(regexp = IDENTIFICATION_NUMBER_VALIDATION_REGEX, message = USER_IDENTITY_NUMBER_INVALID_FORMAT)
        String identityNumber,
        @NotBlank(message = USER_PHONE_NUMBER_NULL_OR_EMPTY)
        @PhoneNumber
        String phoneNumber,
        @NotNull(message = USER_BIRTH_DATE_NULL)
        @MinAge(value = UserValidationConstant.MIN_AGE)
        LocalDate birthDate,
        @NotBlank(message = USER_EMAIL_NULL_OR_EMPTY)
        @Email(message = USER_EMAIL_INVALID_FORMAT)
        String email,
        @NotBlank(message = USER_PASSWORD_NULL_OR_EMPTY)
        @Password
        String password) {
}
