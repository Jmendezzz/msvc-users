package com.emazon.msvc.users.msvcusers.application.handlers;

import com.emazon.msvc.users.msvcusers.application.dtos.role.RoleResponseDto;
import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.application.dtos.user.UserResponseDto;
import com.emazon.msvc.users.msvcusers.application.handlers.imp.UserHandlerImp;
import com.emazon.msvc.users.msvcusers.application.mappers.UserDtoMapper;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserHandlerTest {
  @Mock
  private UserUseCase userUseCase;
  @Mock
  private UserDtoMapper userDtoMapper;

  private UserHandler userHandler;

  @BeforeEach
  void setUp() {
    userHandler = new UserHandlerImp(userUseCase, userDtoMapper);
  }

  @Test
  void testCreateWarehouseAssistant() {
    // Arrange
    CreateUserDtoRequest createUserDtoRequest = new CreateUserDtoRequest(
            "John",
            "Doe",
            "123456789",
            "+573136467009",
            LocalDate.of(1990, 1, 1),
            "test@test.com",
            "P@ssw0rd!123");
    Role warehouseAssistantRole = new Role(1L, RoleConstant.ROLE_WAREHOUSE_ASSISTANT, "Warehouse Assistant Role");
    User userUseCaseResult = new User(1L, "John", "Doe", "123456789", "+573136467009", LocalDate.of(1990, 1, 1), "test@test.com","P@ssw0rd!123", warehouseAssistantRole);
    UserResponseDto expectedResponse = new UserResponseDto(1L, "John", "Doe", "test@test.com", new RoleResponseDto(1L, RoleConstant.ROLE_WAREHOUSE_ASSISTANT));

    when(userUseCase.createWarehouseAssistant(any(User.class))).thenReturn(userUseCaseResult);
    when(userDtoMapper.toDomain(createUserDtoRequest)).thenReturn(userUseCaseResult);
    when(userDtoMapper.toDto(userUseCaseResult)).thenReturn(expectedResponse);

    UserResponseDto result = userHandler.createWarehouseAssistant(createUserDtoRequest);

    assertEquals(expectedResponse, result);
  }
}
