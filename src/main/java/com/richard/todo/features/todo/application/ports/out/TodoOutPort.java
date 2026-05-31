package com.richard.todo.features.todo.application.ports.out;

import com.richard.todo.features.todo.domain.model.TodoModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoOutPort {
    TodoModel save(TodoModel user);

    Optional<TodoModel> findById(UUID id);

    List<TodoModel> findByUserId(UUID email);

    List<TodoModel> findAll();

    void deleteById(UUID id);
}