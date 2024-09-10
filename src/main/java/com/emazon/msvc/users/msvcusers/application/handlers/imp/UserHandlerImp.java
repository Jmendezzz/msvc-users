package com.emazon.msvc.users.msvcusers.application.handlers.imp;

import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.application.handlers.UserHandler;
import com.emazon.msvc.users.msvcusers.application.mappers.UserDtoMapper;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserHandlerImp  implements UserHandler {
  private final UserUseCase userUseCase;
  private final UserDtoMapper mapper;
  @Override
  public UserResponseDto createWarehouseAssistant(CreateUserDtoRequest createUserDtoRequest) {
    User userCreated =  userUseCase.createWarehouseAssistant(mapper.toDomain(createUserDtoRequest));
    return mapper.toDto(userCreated);
  }
}
