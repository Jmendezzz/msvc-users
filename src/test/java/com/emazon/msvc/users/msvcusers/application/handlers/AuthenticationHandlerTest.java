package com.emazon.msvc.users.msvcusers.application.handlers;

import com.emazon.msvc.users.msvcusers.application.dtos.authentication.AuthenticationResponseDto;
import com.emazon.msvc.users.msvcusers.application.dtos.authentication.LoginRequestDto;
import com.emazon.msvc.users.msvcusers.application.handlers.imp.AuthenticationHandlerImp;
import com.emazon.msvc.users.msvcusers.application.mappers.AuthenticationDtoMapper;
import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.AuthenticationUseCase;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationHandlerTest {
  @Mock
  private AuthenticationUseCase authenticationUseCase;

  @Mock
  private AuthenticationDtoMapper mapper;

  @InjectMocks
  private AuthenticationHandlerImp authenticationHandlerImp;

  @Test
  void testLogin() {
    LoginRequestDto loginRequestDto = new LoginRequestDto("test@test.com", "P@ssw0rd!123");
    User user = new User();
    user.setId(1L);
    user.setEmail("test@test.com");
    user.setPassword("P@ssw0rd!123");
    user.setRole(new Role(1L, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_ADMIN_DESCRIPTION));
    Authentication authentication = new Authentication(user, "token");

    AuthenticationResponseDto responseDto = new AuthenticationResponseDto(
            authentication.getToken(),
            user.getId(),
            user.getEmail(),
            user.getRole().getName()
    );

    when(authenticationUseCase.login(loginRequestDto.email(), loginRequestDto.password())).thenReturn(authentication);
    when(mapper.toDto(authentication)).thenReturn(responseDto);

    AuthenticationResponseDto result = authenticationHandlerImp.login(loginRequestDto);

    assertEquals(responseDto, result);
    verify(authenticationUseCase, times(1)).login(loginRequestDto.email(), loginRequestDto.password());
    verify(mapper, times(1)).toDto(authentication);
  }
}
