package com.emazon.msvc.users.msvcusers.application.handlers.imp;

import com.emazon.msvc.users.msvcusers.application.dtos.pagination.PaginationDto;
import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.application.handlers.UserHandler;
import com.emazon.msvc.users.msvcusers.application.mappers.PaginationDtoMapper;
import com.emazon.msvc.users.msvcusers.application.mappers.UserDtoMapper;
import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.Pagination;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserHandlerImp  implements UserHandler {
  private final UserUseCase userUseCase;
  private final UserDtoMapper mapper;
  private final PaginationDtoMapper paginationMapper;
  @Override
  public UserResponseDto createWarehouseAssistant(CreateUserDtoRequest createUserDtoRequest) {
    User userCreated =  userUseCase.createWarehouseAssistant(mapper.toDomain(createUserDtoRequest));
    return mapper.toDto(userCreated);
  }

  @Override
  public Paginated<UserResponseDto> getWarehouseAssistants(PaginationDto pagination) {
    return mapper.toDtoPaginated(userUseCase.getWarehouseAssistants(paginationMapper.toDomain(pagination)));
  }
}
