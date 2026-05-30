package com.richard.todo.features.user.domain.mappers;

import com.richard.todo.features.user.domain.model.UserModel;
import com.richard.todo.features.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMappers {
    UserModel toModel(UserEntity entity);

    UserEntity toEntity(UserModel model);
}