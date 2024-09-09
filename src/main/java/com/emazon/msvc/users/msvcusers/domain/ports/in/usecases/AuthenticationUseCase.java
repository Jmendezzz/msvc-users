package com.emazon.msvc.users.msvcusers.domain.ports.in.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.Authentication;

public interface AuthenticationUseCase {
  Authentication login(String email, String password);
}
