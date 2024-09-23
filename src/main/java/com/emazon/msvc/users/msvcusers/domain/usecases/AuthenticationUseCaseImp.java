package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.exceptions.authentication.InvalidCredentialsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.authentication.InvalidTokenException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.UserNotFoundException;
import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.AuthenticationUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;

import java.util.Optional;

public class AuthenticationUseCaseImp implements AuthenticationUseCase {
  private final UserUseCase userUseCase;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenService tokenService;
  public AuthenticationUseCaseImp(UserUseCase userUseCase, UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
    this.userUseCase = userUseCase;
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

  @Override
  public Authentication signUp(User user) {
    User userCreated = userUseCase.createCustomer(user);
    userCreated.setEmptyPassword();

    String token = tokenService.generateToken(userCreated.getEmail(), userCreated.getId(),userCreated.getRole());
    return new Authentication(userCreated, token);
  }

  @Override
  public User getUserDetails(String token) {
    if(!tokenService.validateToken(token)) throw new InvalidTokenException();
    String email = tokenService.getUsernameFromToken(token);
    Optional<User> user = userRepository.findUserByEmail(email);

    if(user.isEmpty()) throw new UserNotFoundException();

    User userDetails = user.get();
    userDetails.setEmptyPassword();

    return userDetails;
  }
}
