package com.emazon.msvc.users.msvcusers.domain.ports.in.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.Role;

import java.util.Optional;

public interface RoleUseCase {
  Optional<Role> getRoleByName(String roleName);
}
