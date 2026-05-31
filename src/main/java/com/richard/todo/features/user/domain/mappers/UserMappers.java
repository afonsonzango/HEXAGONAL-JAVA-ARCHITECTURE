package com.richard.todo.features.user.domain.mappers;

import com.richard.todo.features.user.application.dtos.UserResponseDTO;
import com.richard.todo.features.user.domain.model.UserModel;
import com.richard.todo.features.user.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMappers {
    @Mapping(ignore = true, target = "todos")
    UserModel toModel(UserEntity entity);

    UserEntity toEntity(UserModel model);

    UserResponseDTO toResponseDTO(UserModel model);
}