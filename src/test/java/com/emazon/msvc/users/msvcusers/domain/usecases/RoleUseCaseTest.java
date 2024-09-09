package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleUseCaseTest {

  @Mock
  private RoleRepository roleRepository;
  @InjectMocks
  private RoleUseCaseImp roleUseCaseImp;

  @Test
  void testGetRoleByName() {
    Role role = new Role(1L, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_ADMIN_DESCRIPTION);
    when(roleRepository.findRoleByName(role.getName())).thenReturn(Optional.of(role));

    Optional<Role> result = roleUseCaseImp.getRoleByName(role.getName());

    assertEquals(Optional.of(role), result);
    verify(roleRepository, times(1)).findRoleByName(role.getName());
  }

  @Test
  void testGetRoleByNonExistingName(){
    Role role = new Role(1L, RoleConstant.ROLE_ADMIN, RoleConstant.ROLE_ADMIN_DESCRIPTION);
    when(roleRepository.findRoleByName(role.getName())).thenReturn(Optional.empty());

    Optional<Role> result = roleUseCaseImp.getRoleByName(role.getName());

    assertEquals(Optional.empty(), result);
    verify(roleRepository, times(1)).findRoleByName(role.getName());
  }
}
