package com.emazon.msvc.users.msvcusers.application.dtos.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDto(

        @NotBlank
        @Email
    String email,
    String password
) {
}
