package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.repositories;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.RoleRepository;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.mappers.RoleEntityMapper;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.repositories.jpa.RoleJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {
  private final RoleJpaRepository jpaRepository;
  private final RoleEntityMapper mapper;
  @Override
  public Optional<Role> findRoleByName(String roleName) {
    return jpaRepository.findByName(roleName).map(mapper::toDomain);
  }
}
