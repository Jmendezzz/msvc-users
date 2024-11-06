package com.emazon.msvc.users.msvcusers.application.mappers;

import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
  User toDomain(CreateUserDtoRequest createUserDtoRequest);
  List<UserResponseDto> toDto(List<User> users);
  UserResponseDto toDto(User user);
  @Mapping(target = "data", expression = "java(toDto(paginated.getData()))")
  @Mapping(target = "currentPage", expression = "java(paginated.getCurrentPage())")
  @Mapping(target = "totalItems", expression = "java(paginated.getTotalItems())")
  @Mapping(target = "totalPages", expression = "java(paginated.getTotalPages())")
  Paginated<UserResponseDto> toDtoPaginated(Paginated<User> paginated);

}
