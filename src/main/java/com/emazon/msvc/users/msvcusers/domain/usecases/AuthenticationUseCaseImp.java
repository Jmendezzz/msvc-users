package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.exceptions.authentication.InvalidCredentialsException;
import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.AuthenticationUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;

import java.util.Optional;

public class AuthenticationUseCaseImp implements AuthenticationUseCase {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenService tokenService;
  public AuthenticationUseCaseImp(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.tokenService = tokenService;
  }
  @Override
  public Authentication login(String email, String password) {
    Optional<User> user = userRepository.findUserByEmail(email);

    if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) throw new InvalidCredentialsException();

    User authenticatedUser = user.get();
    authenticatedUser.setEmptyPassword();

    String token = tokenService.generateToken(authenticatedUser.getEmail(), authenticatedUser.getId(),authenticatedUser.getRole());

    return new Authentication(authenticatedUser, token);
  }
}
