package com.emazon.msvc.users.msvcusers.domain.ports.in.usecases;

import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.Pagination;
import com.emazon.msvc.users.msvcusers.domain.models.User;

public interface UserUseCase {
  User createWarehouseAssistant(User user);
  User createCustomer(User user);
  Paginated<User> getWarehouseAssistants(Pagination pagination);
}
