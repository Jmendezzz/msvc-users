package com.emazon.msvc.users.msvcusers.application.handlers;

import com.emazon.msvc.users.msvcusers.application.dtos.pagination.PaginationDto;
import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.Pagination;

public interface UserHandler {
  UserResponseDto createWarehouseAssistant(CreateUserDtoRequest createUserDtoRequest);
  Paginated<UserResponseDto> getWarehouseAssistants(PaginationDto pagination);
}
