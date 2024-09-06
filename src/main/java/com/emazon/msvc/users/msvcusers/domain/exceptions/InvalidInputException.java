package com.emazon.msvc.users.msvcusers.domain.exceptions;

public class InvalidInputException extends BusinessException{
  public InvalidInputException(String message, String code) {
    super(message, code);
  }
}
