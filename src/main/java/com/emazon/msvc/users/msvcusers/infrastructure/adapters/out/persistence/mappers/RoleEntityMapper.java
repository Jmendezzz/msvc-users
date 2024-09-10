package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.mappers;

import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {
  Role toDomain(RoleEntity roleEntity);
  RoleEntity toEntity(Role role);
}
