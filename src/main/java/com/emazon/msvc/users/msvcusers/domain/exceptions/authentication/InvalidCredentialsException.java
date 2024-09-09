package com.emazon.msvc.users.msvcusers.domain.exceptions.authentication;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.authentication.AuthenticationExceptionCode;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.authentication.AuthenticationExceptionMessage;

public class InvalidCredentialsException extends BusinessException {
  public InvalidCredentialsException() {
    super(AuthenticationExceptionMessage.INVALID_CREDENTIALS_MESSAGE, AuthenticationExceptionCode.INVALID_CREDENTIALS_CODE);
  }
}
