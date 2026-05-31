package com.richard.todo.features.todo.infrastructure.repository;

import com.richard.todo.features.todo.infrastructure.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TodoRepositoryAdapter extends JpaRepository<TodoEntity, UUID> {
    List<TodoEntity> findByUser_Id(UUID id);
}
