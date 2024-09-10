package com.emazon.msvc.users.msvcusers.domain.exceptions.role;

import com.emazon.msvc.users.msvcusers.domain.exceptions.BusinessException;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleExceptionCode;
import com.emazon.msvc.users.msvcusers.domain.utils.constants.role.RoleExceptionMessage;

public class RoleNotFoundException extends BusinessException {
  public RoleNotFoundException() {
    super(RoleExceptionMessage.ROLE_NOT_FOUND, RoleExceptionCode.ROLE_NOT_FOUND_CODE);
  }
}
