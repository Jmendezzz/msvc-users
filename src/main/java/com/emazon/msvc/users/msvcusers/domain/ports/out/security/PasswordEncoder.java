package com.emazon.msvc.users.msvcusers.domain.ports.out.security;

public interface PasswordEncoder {
  String encode(String password);
  boolean matches(String password, String encodedPassword);
}
