package com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.mappers;

import com.emazon.msvc.users.msvcusers.domain.models.User;
import com.emazon.msvc.users.msvcusers.infrastructure.adapters.out.persistence.entities.UserEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class})
public interface UserEntityMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity userEntity);
}
