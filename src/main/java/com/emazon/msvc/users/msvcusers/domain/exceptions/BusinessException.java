package com.emazon.msvc.users.msvcusers.domain.exceptions;

public class BusinessException extends RuntimeException{
    public String code;
    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }
}
