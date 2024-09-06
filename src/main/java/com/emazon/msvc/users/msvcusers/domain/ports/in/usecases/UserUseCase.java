package com.emazon.msvc.users.msvcusers.domain.ports.in.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.User;

public interface UserUseCase {
  User createUser(User user);
}
