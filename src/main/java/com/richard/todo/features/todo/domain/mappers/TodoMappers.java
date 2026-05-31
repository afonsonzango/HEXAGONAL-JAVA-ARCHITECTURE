package com.richard.todo.features.todo.domain.mappers;

import com.richard.todo.features.todo.application.dtos.TodoResponseDTO;
import com.richard.todo.features.todo.domain.model.TodoModel;
import com.richard.todo.features.todo.infrastructure.entity.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMappers {
    @Mapping(ignore = true, target = "user")
    TodoModel toModel(TodoEntity entity);

    TodoEntity toEntity(TodoModel model);

    TodoResponseDTO toResponseDTO(TodoModel model);
}