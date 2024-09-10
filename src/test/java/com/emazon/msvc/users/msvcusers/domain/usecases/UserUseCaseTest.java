package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.exceptions.role.RoleNotFoundException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.EmailAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.IdentityNumberAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.PhoneNumberAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.RoleUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {
  @Mock
  private RoleUseCase roleUseCase;
  @Mock
  private UserRepository userRepository;
  @Mock
  private PasswordEncoder passwordEncoder;
  @InjectMocks
  private UserUseCaseImp userUseCase;

  private User user;
  private Role role;
  @BeforeEach
  void setUp() {
    role = new Role(1L, RoleConstant.ROLE_WAREHOUSE_ASSISTANT,  "Warehouse Assistant");

    user = new User();
    user.setId(1L);
    user.setFirstName("Test");
    user.setLastName("User");
    user.setEmail("test@email.com");
    user.setIdentityNumber("1054544092");
    user.setPhoneNumber("+573005698325");
    user.setBirthDate(LocalDate.of(2005, 9, 23));
    user.setPassword("Password_123*");
    user.setRole(role);

  }
  @Test
  void testCreateWarehouseAssistant() {
    when(roleUseCase.getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT)).thenReturn(Optional.of(role));
    when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.empty());
    when(userRepository.findUserByIdentityNumber(user.getIdentityNumber())).thenReturn(Optional.empty());
    when(userRepository.findUserByPhoneNumber(user.getPhoneNumber())).thenReturn(Optional.empty());
    when(passwordEncoder.encode(user.getPassword())).thenReturn(user.getPassword());
    when(userRepository.saveUser(user)).thenReturn(user);

    User result = userUseCase.createWarehouseAssistant(user);

    assertEquals(role, result.getRole());
    assertEquals(user, result);

    verify(passwordEncoder).encode(user.getPassword());
    verify(userRepository).findUserByEmail(user.getEmail());
    verify(userRepository).findUserByIdentityNumber(user.getIdentityNumber());
    verify(userRepository).findUserByPhoneNumber(user.getPhoneNumber());
    verify(userRepository).saveUser(user);
  }
  @Test
  void createWarehouseAssistantRoleNotFound() {
    // Given
    when(roleUseCase.getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT)).thenReturn(Optional.empty());

    // When & Then
    assertThrows(RoleNotFoundException.class, () -> userUseCase.createWarehouseAssistant(user));
  }


  @Test
  void testCreateWarehouseAssistantWithExistingEmail() {
    when(roleUseCase.getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT)).thenReturn(Optional.of(role));
    when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.of(user));

    assertThrows(EmailAlreadyExistsException.class, () -> userUseCase.createWarehouseAssistant(user));

    verify(roleUseCase).getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT);
    verify(userRepository).findUserByEmail(user.getEmail());
  }
  @Test
  void testCreateWarehouseAssistantWithExistingIdentityNumber() {
    when(roleUseCase.getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT)).thenReturn(Optional.of(role));
    when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.empty());
    when(userRepository.findUserByIdentityNumber(user.getIdentityNumber())).thenReturn(Optional.of(user));

    assertThrows(IdentityNumberAlreadyExistsException.class, () -> userUseCase.createWarehouseAssistant(user));

    verify(roleUseCase).getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT);
    verify(userRepository).findUserByEmail(user.getEmail());
    verify(userRepository).findUserByIdentityNumber(user.getIdentityNumber());
  }

  @Test
  void testCreateWarehouseAssistantWithExistingPhoneNumber() {
    when(roleUseCase.getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT)).thenReturn(Optional.of(role));
    when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.empty());
    when(userRepository.findUserByIdentityNumber(user.getIdentityNumber())).thenReturn(Optional.empty());
    when(userRepository.findUserByPhoneNumber(user.getPhoneNumber())).thenReturn(Optional.of(user));

    assertThrows(PhoneNumberAlreadyExistsException.class, () -> userUseCase.createWarehouseAssistant(user));

    verify(roleUseCase).getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT);
    verify(userRepository).findUserByEmail(user.getEmail());
    verify(userRepository).findUserByIdentityNumber(user.getIdentityNumber());
    verify(userRepository).findUserByPhoneNumber(user.getPhoneNumber());
  }
}
