package com.emazon.msvc.users.msvcusers.application.mappers;

import com.emazon.msvc.users.msvcusers.application.dtos.pagination.PaginationDto;
import com.emazon.msvc.users.msvcusers.domain.models.Pagination;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaginationDtoMapper {
  Pagination toDomain(PaginationDto paginationDto);
}
