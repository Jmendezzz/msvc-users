package com.emazon.msvc.users.msvcusers.application.dtos.authentication;

import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(
    @NotBlank(message = UserExceptionMessage.USER_EMAIL_NULL_OR_EMPTY)
    @Email(message = UserExceptionMessage.USER_EMAIL_INVALID_FORMAT)
    String email,
    @NotBlank(message = UserExceptionMessage.USER_PASSWORD_NULL_OR_EMPTY)
    String password
) {
}
