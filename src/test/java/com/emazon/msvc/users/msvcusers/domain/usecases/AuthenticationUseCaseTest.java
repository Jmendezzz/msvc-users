package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.exceptions.authentication.InvalidCredentialsException;
import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.TokenService;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationUseCaseTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  @Mock
  private TokenService tokenService;
  private AuthenticationUseCaseImp authenticationUseCaseImp;

 @BeforeEach
  void setUp() {
    authenticationUseCaseImp = new AuthenticationUseCaseImp(userRepository, passwordEncoder, tokenService);
  }

  @Test
  void testLoginSuccess() {
    User user = new User();
    user.setEmail("test@test.com");
    user.setPassword("P@ssw0rd!123");
    user.setRole(
            new Role(1L, RoleConstant.ROLE_ADMIN, "Admin")
    );

    when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.of(user));
    when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
    when(tokenService.generateToken(eq(user.getEmail()), any(), eq(user.getRole()))).thenReturn("token");
    Authentication authentication = authenticationUseCaseImp.login(user.getEmail(), "P@ssw0rd!123");

    assertEquals(user.getEmail(), authentication.getUser().getEmail());
    assertEquals("token", authentication.getToken());

    verify(userRepository, times(1)).findUserByEmail(user.getEmail());
    verify(passwordEncoder, times(1)).matches(anyString(), anyString());
    verify(tokenService, times(1)).generateToken(anyString(), any(), any(Role.class));
  }

  @Test
  void testLoginFailUserNotFound() {
    when(userRepository.findUserByEmail(anyString())).thenReturn(Optional.empty());

    assertThrows(InvalidCredentialsException.class, () -> authenticationUseCaseImp.login("test@test.com", "password"));

    verify(userRepository, times(1)).findUserByEmail(anyString());
  }

  @Test
  void testLoginFailInvalidPassword() {
    User user = new User();
    user.setEmail("test@test.com");
    user.setPassword("P@ssw0rd!123");
    user.setRole(
            new Role(1L, RoleConstant.ROLE_ADMIN, "Admin")
    );

    when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.of(user));
    when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);

    assertThrows(InvalidCredentialsException.class, () -> authenticationUseCaseImp.login(user.getEmail(), "P@ssw0rd!123"));

    verify(userRepository, times(1)).findUserByEmail(user.getEmail());
    verify(passwordEncoder, times(1)).matches(anyString(), anyString());
  }
}