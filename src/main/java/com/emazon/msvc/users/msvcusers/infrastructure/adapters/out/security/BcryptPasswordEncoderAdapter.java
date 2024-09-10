package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.security;

import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncoderAdapter implements PasswordEncoder {
  private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
  @Override
  public String encode(String password) {
    return bCryptPasswordEncoder.encode(password);
  }

  @Override
  public boolean matches(String password, String encodedPassword) {
    return bCryptPasswordEncoder.matches(password,encodedPassword);
  }
}
