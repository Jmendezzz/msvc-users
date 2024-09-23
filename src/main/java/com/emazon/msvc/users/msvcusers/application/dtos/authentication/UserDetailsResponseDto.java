package com.emazon.msvc.users.msvcusers.application.dtos.authentication;

public record UserDetailsResponseDto(
    String id,
    String email,
    String role
) {
}
