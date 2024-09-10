package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.RoleUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;

import java.util.Optional;

public class RoleUseCaseImp implements RoleUseCase {
  private final RoleRepository roleRepository;
  public RoleUseCaseImp(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Optional<Role> getRoleByName(String roleName) {
    return roleRepository.findRoleByName(roleName);
  }
}
