package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.mappers;

import com.emazon.msvc.users.msvcusers.domain.models.Paginated;
import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;


@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class})
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
    List<User> toDomain(List<UserEntity> users);
    @Mapping(target = "data", expression = "java(toDomain((page.getContent())))")
    @Mapping(target = "currentPage", expression = "java((long) page.getNumber())")
    @Mapping(target = "totalItems", expression = "java(page.getTotalElements())")
    @Mapping(target = "totalPages", expression = "java((long) page.getTotalPages())")
    Paginated<User> toDomainPaginated(Page<UserEntity> page);
}
