package com.emazon.msvc.users.msvcusers.application.mappers;

import com.emazon.msvc.users.msvcusers.application.dtos.authentication.AuthenticationResponseDto;
import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthenticationDtoMapper {

  @Mapping(source = "user.id", target = "id")
  @Mapping(source = "user.email", target = "email")
  @Mapping(source = "user.role.name", target = "role")
  AuthenticationResponseDto toDto(Authentication authentication);
}
