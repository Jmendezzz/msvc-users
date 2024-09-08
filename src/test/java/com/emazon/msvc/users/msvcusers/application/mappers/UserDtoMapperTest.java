package com.emazon.msvc.users.msvcusers.application.mappers;

import com.emazon.msvc.users.msvcusers.application.dtos.user.CreateUserDtoRequest;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserDtoMapperTest {

  private UserDtoMapper userDtoMapper;

  @BeforeEach
  void setUp() {
    userDtoMapper = Mappers.getMapper(UserDtoMapper.class);
  }

  @Test
  void testFromCreateUserDtoToDomain() {
    // Arrange
    CreateUserDtoRequest createUserDtoRequest = new CreateUserDtoRequest(
      "John",
      "Doe",
      "123456789",
      "+573136467009",
       LocalDate.of(1990, 1, 1),
       "email@test.com",
       "P@ssw0rd!123"
    );

    // Act
    User user = userDtoMapper.toDomain(createUserDtoRequest);

    // Assert
    assertEquals(createUserDtoRequest.firstName(), user.getFirstName());
    assertEquals(createUserDtoRequest.lastName(), user.getLastName());
    assertEquals(createUserDtoRequest.identityNumber(), user.getIdentityNumber());
    assertEquals(createUserDtoRequest.phoneNumber(), user.getPhoneNumber());
    assertEquals(createUserDtoRequest.birthDate(), user.getBirthDate());
    assertEquals(createUserDtoRequest.email(), user.getEmail());
    assertEquals(createUserDtoRequest.password(), user.getPassword());
  }


}
