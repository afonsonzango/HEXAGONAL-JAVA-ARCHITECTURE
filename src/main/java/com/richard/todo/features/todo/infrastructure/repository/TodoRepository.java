package com.richard.todo.features.todo.infrastructure.repository;

import com.richard.todo.features.todo.application.ports.out.TodoOutPort;
import com.richard.todo.features.todo.domain.mappers.TodoMappers;
import com.richard.todo.features.todo.domain.model.TodoModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoRepository implements TodoOutPort {
    private final TodoRepositoryAdapter todoRepositoryAdapter;
    private final TodoMappers todoMappers;

    public TodoRepository(TodoRepositoryAdapter todoRepositoryAdapter, TodoMappers todoMappers) {
        this.todoRepositoryAdapter = todoRepositoryAdapter;
        this.todoMappers = todoMappers;
    }

    @Override
    public TodoModel save(TodoModel user) {
        return this.todoMappers.toModel(todoRepositoryAdapter.save(this.todoMappers.toEntity(user)));
    }

    @Override
    public Optional<TodoModel> findById(UUID id) {
        return this.todoRepositoryAdapter.findById(id).map(todoMappers::toModel);
    }

    @Override
    public List<TodoModel> findByUserId(UUID userId) {
        return this.todoRepositoryAdapter.findByUser_Id(userId).stream().map(todoMappers::toModel).toList();
    }

    @Override
    public List<TodoModel> findAll() {
        return this.todoRepositoryAdapter.findAll().stream().map(todoMappers::toModel).toList();
    }

    @Override
    public void deleteById(UUID id) {
        this.todoRepositoryAdapter.deleteById(id);
    }
}
