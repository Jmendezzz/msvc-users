package com.emazon.msvc.users.msvcusers.domain.ports.in.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.Authentication;
import com.emazon.msvc.users.msvcusers.domain.models.User;

public interface AuthenticationUseCase {
  Authentication login(String email, String password);
  Authentication signUp(User user);
  User getUserDetails(String token);
}
