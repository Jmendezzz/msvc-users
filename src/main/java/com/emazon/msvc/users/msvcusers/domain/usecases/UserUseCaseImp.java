package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.exceptions.role.RoleNotFoundException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.EmailAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.IdentityNumberAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.PhoneNumberAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.models.Role;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.RoleUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;
import com.emazon.msvc.users.msvcusers.domain.ports.out.security.PasswordEncoder;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleConstant;

public class UserUseCaseImp implements UserUseCase {
  private final RoleUseCase roleUseCase;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  public UserUseCaseImp(UserRepository userRepository, RoleUseCase roleUseCase, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleUseCase = roleUseCase;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User createWarehouseAssistant(User user) {
    Role warehouseAssistantRole = roleUseCase
            .getRoleByName(RoleConstant.ROLE_WAREHOUSE_ASSISTANT)
            .orElseThrow(RoleNotFoundException::new);

    user.setRole(warehouseAssistantRole);

    return createUser(user);
  }

  private User createUser(User user) {
    validateUniqueFields(user);

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    return userRepository.saveUser(user);
  }
  private void validateUniqueFields(User user) {
    if(userRepository.findUserByEmail(user.getEmail()).isPresent()) throw new EmailAlreadyExistsException();

    if(userRepository.findUserByIdentityNumber(user.getIdentityNumber()).isPresent()) throw new IdentityNumberAlreadyExistsException();

    if(userRepository.findUserByPhoneNumber(user.getPhoneNumber()).isPresent()) throw new PhoneNumberAlreadyExistsException();
  }

}
