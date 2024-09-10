package com.emazon.msvc.users.msvcusers.application.dtos.authentication;

public record AuthenticationResponseDto(
    String token,
    Long id,
    String email,
    String role
) {
}
