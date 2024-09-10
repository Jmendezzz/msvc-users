package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.repositories.jpa;

import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {
  Optional<RoleEntity> findByName(String name);
}
