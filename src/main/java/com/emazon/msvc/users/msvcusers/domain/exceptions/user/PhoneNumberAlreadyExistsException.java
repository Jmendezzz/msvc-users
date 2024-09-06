package com.emazon.msvc.users.msvcusers.domain.exceptions.user;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.UserExceptionCode;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.UserExceptionMessage;

public class PhoneNumberAlreadyExistsException extends BusinessException {
  public PhoneNumberAlreadyExistsException() {
    super(UserExceptionMessage.USER_PHONE_NUMBER_ALREADY_EXISTS, UserExceptionCode.USER_PHONE_NUMBER_ALREADY_EXISTS_CODE);
  }
}
