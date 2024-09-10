package com.emazon.msvc.users.msvcusers.application.dtos.user;

import com.emazon.msvc.users.msvcusers.application.dtos.role.RoleResponseDto;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        RoleResponseDto role
) {
}
