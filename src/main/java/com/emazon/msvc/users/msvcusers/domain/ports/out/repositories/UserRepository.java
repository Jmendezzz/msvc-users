package com.emazon.msvc.users.msvcusers.domain.ports.out.repositories;

import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.Pagination;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;

import java.util.Optional;

public interface UserRepository {
  User saveUser(User user);
  Optional<User> findUserById(Long id);
  Optional<User> findUserByEmail(String email);
  Optional<User> findUserByIdentityNumber(String identityNumber);
  Optional<User> findUserByPhoneNumber(String phoneNumber);
  Paginated<User> findAllUsersByRole(String roleName, Pagination pagination);
}
