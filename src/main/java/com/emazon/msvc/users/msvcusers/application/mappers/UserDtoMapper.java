package com.emazon.msvc.users.msvcusers.application.mappers;

import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
  User toDomain(CreateUserDtoRequest createUserDtoRequest);
  UserResponseDto toDto(User user);

}
