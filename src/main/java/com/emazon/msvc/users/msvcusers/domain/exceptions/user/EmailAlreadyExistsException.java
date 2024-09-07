package com.emazon.msvc.users.msvcusers.domain.exceptions.user;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionCode;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.user.UserExceptionMessage;

public class EmailAlreadyExistsException extends BusinessException {
  public EmailAlreadyExistsException() {
    super(UserExceptionMessage.USER_EMAIL_ALREADY_EXISTS, UserExceptionCode.USER_EMAIL_ALREADY_EXISTS_CODE);
  }
}
