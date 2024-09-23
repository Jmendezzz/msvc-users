package com.emazon.msvc.users.msvcusers.application.handlers;

import com.emazon.msvc.users.msvcusers.application.dtos.authentication.AuthenticationResponseDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.LoginRequestDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.SignUpRequestDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.UserDetailsResponseDto;

public interface AuthenticationHandler {
  AuthenticationResponseDto login(LoginRequestDto loginRequestDto);
  AuthenticationResponseDto signUp(SignUpRequestDto signUpRequestDto);
  UserDetailsResponseDto getUserDetails(String token);

}
