package com.emazon.msvc.users.msvcusers.domain.ports.out.repositories;

import com.emazon.msvc.users.msvcusers.domain.models.Role;

import java.util.Optional;

public interface RoleRepository {
  void saveRole(Role role);
  Optional<Role> findRoleByName(String roleName);
}
