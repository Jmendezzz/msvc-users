package com.emazon.msvc.users.msvcusers.application.dtos.pagination;

import jakarta.validation.constraints.Min;

import static com.emazon.msvc.users.msvcusers.domain.utils.constants.pagination.PaginationValidationConstant.MIN_PAGE;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.pagination.PaginationValidationConstant.MIN_PAGE_SIZE;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.pagination.PaginationValidationMessage.INVALID_PAGE_NUMBER;
import static com.emazon.msvc.users.msvcusers.domain.utils.constants.pagination.PaginationValidationMessage.INVALID_PAGE_SIZE;

public record PaginationDto(
        @Min(value = MIN_PAGE, message = INVALID_PAGE_NUMBER)
        Integer page,
        @Min(value = MIN_PAGE_SIZE, message = INVALID_PAGE_SIZE)
        Integer size
) {
}