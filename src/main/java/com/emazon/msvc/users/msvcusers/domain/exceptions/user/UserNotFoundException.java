package com.emazon.msvc.users.msvcusers.domain.exceptions.user;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionCode.USER_NOT_FOUND_CODE;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage.USER_NOT_FOUND;

public class UserNotFoundException extends BusinessException {
  public UserNotFoundException() {
    super(USER_NOT_FOUND, USER_NOT_FOUND_CODE);
  }
}
