package com.emazon.msvc.users.msvcusers.application.handlers;

import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;

public interface UserHandler {
  UserResponseDto createWarehouseAssistant(CreateUserDtoRequest createUserDtoRequest);
}
