package com.emazon.msvc.users.msvcusers.application.mappers;

import com.emazon.msvc.users.msvcusers.application.dtos.authentication.AuthenticationResponseDto;
import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthenticationDtoMapperTest {
  private AuthenticationDtoMapper authenticationDtoMapper;
  @BeforeEach
  void setUp() {
    authenticationDtoMapper = Mappers.getMapper(AuthenticationDtoMapper.class);
  }

  @Test
  void toDtoTest() {
    // Given
    User user = new User();
    user.setId(1L);
    user.setEmail("admin@example.com");
    user.setRole(new Role(1L, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_ADMIN_DESCRIPTION));

    String token = "token";

    Authentication authentication = new Authentication(user,token);

    AuthenticationResponseDto authenticationResponseDto = authenticationDtoMapper.toDto(authentication);

    assertEquals(user.getId(), authenticationResponseDto.id());
    assertEquals(user.getEmail(), authenticationResponseDto.email());
    assertEquals(user.getRole().getName(), authenticationResponseDto.role());


  }
}
