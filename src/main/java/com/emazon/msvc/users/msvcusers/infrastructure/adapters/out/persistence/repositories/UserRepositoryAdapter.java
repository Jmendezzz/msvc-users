package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.repositories;

import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.Pagination;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities.UserEntity;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.mappers.UserEntityMapper;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.repositories.jpa.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

  private final UserJpaRepository repository;
  private final UserEntityMapper mapper;

  @Override
  public User saveUser(User user) {
    UserEntity userEntity = repository.save(mapper.toEntity(user));
    return mapper.toDomain(userEntity);
  }

  @Override
  public Optional<User> findUserById(Long id) {
    return repository.findById(id).map(mapper::toDomain);
  }

  @Override
  public Optional<User> findUserByEmail(String email) {
    return repository.findByEmail(email).map(mapper::toDomain);
  }

  @Override
  public Optional<User> findUserByIdentityNumber(String identityNumber) {
    return repository.findByIdentityNumber(identityNumber).map(mapper::toDomain);
  }

  @Override
  public Optional<User> findUserByPhoneNumber(String phoneNumber) {
    return repository.findByPhoneNumber(phoneNumber).map(mapper::toDomain);
  }

  @Override
  public Paginated<User> findAllUsersByRole(String roleName, Pagination pagination) {
    Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
    return mapper.toDomainPaginated(repository.findAllByRoleName(roleName, pageable));
  }
}
