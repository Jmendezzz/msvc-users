package com.emazon.msvc.users.msvcusers.domain.exceptions.user;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.UserExceptionCode;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.UserExceptionMessage;

public class IdentityNumberAlreadyExistsException extends BusinessException {
  public IdentityNumberAlreadyExistsException() {
    super(UserExceptionMessage.USER_IDENTITY_NUMBER_ALREADY_EXISTS, UserExceptionCode.USER_IDENTITY_NUMBER_ALREADY_EXISTS_CODE);
  }
}
