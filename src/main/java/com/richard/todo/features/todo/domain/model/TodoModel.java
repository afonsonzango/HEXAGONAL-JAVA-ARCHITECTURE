package com.richard.todo.features.todo.domain.model;

import com.richard.todo.features.todo.domain.enums.TodoPriorityEnum;
import com.richard.todo.features.user.infrastructure.entity.UserEntity;

import java.time.Instant;
import java.util.UUID;

public class TodoModel {
    private UUID id;
    private String name;
    private String description;
    private TodoPriorityEnum priority = TodoPriorityEnum.PENDING;
    private UserEntity user;
    private Instant createdAt;
    private Instant updatedAt;

    public TodoModel() {
    }

    public TodoModel(UUID id, String name, String description, TodoPriorityEnum priority, UserEntity user, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(TodoPriorityEnum priority) {
        this.priority = priority;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
