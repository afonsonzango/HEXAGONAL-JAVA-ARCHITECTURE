package com.richard.todo.features.todo.application.dtos;

import com.richard.todo.features.todo.domain.enums.TodoPriorityEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class CreateTodoRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Maximum is 100")
    private String name;

    @Size(max = 500, message = "Maximum is 100")
    private String description;

    private TodoPriorityEnum priority;

    @NotNull(message = "User id is required")
    private UUID userId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TodoPriorityEnum getPriority() {
        return priority;
    }

    public UUID getUserId() {
        return userId;
    }
}