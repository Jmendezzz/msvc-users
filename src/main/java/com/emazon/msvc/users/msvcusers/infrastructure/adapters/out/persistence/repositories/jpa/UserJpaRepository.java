package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.repositories.jpa;

import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long>{
  Optional<UserEntity> findByEmail(String email);
  Optional<UserEntity> findByIdentityNumber(String identityNumber);
  Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}