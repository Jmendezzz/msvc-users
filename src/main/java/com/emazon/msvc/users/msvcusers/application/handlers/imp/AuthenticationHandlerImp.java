package com.emazon.msvc.users.msvcusers.application.handlers.imp;

import com.emazon.msvc.users.msvcusers.application.dtos.authentication.AuthenticationResponseDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.LoginRequestDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.SignUpRequestDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.UserDetailsResponseDto;
import com.emazon.msvc.users.msvcusers.application.handlers.AuthenticationHandler;
import com.emazon.msvc.users.msvcusers.application.mappers.AuthenticationDtoMapper;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.AuthenticationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationHandlerImp implements AuthenticationHandler {
  private final AuthenticationUseCase authenticationUseCase;
  private final AuthenticationDtoMapper mapper;
  @Override
  public AuthenticationResponseDto login(LoginRequestDto loginRequestDto) {
    return mapper.toDto(authenticationUseCase.login(loginRequestDto.email(), loginRequestDto.password()));
  }

  @Override
  public AuthenticationResponseDto signUp(SignUpRequestDto signUpRequestDto) {
    return mapper.toDto(authenticationUseCase.signUp(mapper.toDomain(signUpRequestDto)));
  }

  @Override
  public UserDetailsResponseDto getUserDetails(String token) {
    return mapper.toDto(authenticationUseCase.getUserDetails(token));
  }
}
