package com.emazon.msvc.users.msvcusers.domain.ports.out.repositories;

import com.emazon.msvc.users.msvcusers.domain.models.Role;

import java.util.Optional;

public interface RoleRepository {
  Optional<Role> findRoleByName(String roleName);
}
