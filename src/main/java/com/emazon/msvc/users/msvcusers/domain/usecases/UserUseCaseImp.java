package com.emazon.msvc.users.msvcusers.domain.usecases;

import com.emazon.msvc.users.msvcusers.domain.exceptions.user.EmailAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.IdentityNumberAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.exceptions.user.PhoneNumberAlreadyExistsException;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.domain.ports.in.usecases.UserUseCase;
import com.emazon.msvc.users.msvcusers.domain.ports.out.repositories.UserRepository;

public class UserUseCaseImp implements UserUseCase {
  private final UserRepository userRepository;
  public UserUseCaseImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  @Override
  public User createUser(User user) {
    validateUniqueFields(user);

    return userRepository.saveUser(user);
  }
  private void validateUniqueFields(User user) {
    if(userRepository.findUserByEmail(user.getEmail()).isPresent()) throw new EmailAlreadyExistsException();

    if(userRepository.findUserByIdentityNumber(user.getIdentityNumber()).isPresent()) throw new IdentityNumberAlreadyExistsException();

    if(userRepository.findUserByPhoneNumber(user.getPhoneNumber()).isPresent()) throw new PhoneNumberAlreadyExistsException();
  }
}
