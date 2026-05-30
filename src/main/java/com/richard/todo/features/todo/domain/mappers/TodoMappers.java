package com.richard.todo.features.todo.domain.mappers;

import com.richard.todo.features.todo.domain.model.TodoModel;
import com.richard.todo.features.todo.infrastructure.entity.TodoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMappers {
    TodoModel toModel(TodoEntity entity);

    TodoEntity toEntity(TodoModel model);
}