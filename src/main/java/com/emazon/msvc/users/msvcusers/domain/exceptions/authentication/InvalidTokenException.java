package com.emazon.msvc.users.msvcusers.domain.exceptions.authentication;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.authentication.AuthenticationExceptionCode.INVALID_TOKEN_CODE;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.authentication.AuthenticationExceptionMessage.INVALID_TOKEN_MESSAGE;

public class InvalidTokenException extends BusinessException {
  public InvalidTokenException() {
    super(INVALID_TOKEN_MESSAGE,INVALID_TOKEN_CODE);
  }
}
