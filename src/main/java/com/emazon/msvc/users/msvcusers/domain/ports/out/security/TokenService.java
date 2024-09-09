package com.emazon.msvc.users.msvcusers.domain.ports.out.security;

import com.emazon.msvc.users.msvcusers.domain.models.Role;

public interface TokenService {
    String generateToken(String username, Long userId , Role role);
    boolean validateToken(String token);
    String getUsernameFromToken(String token);
    String getRoleFromToken(String token);
}
