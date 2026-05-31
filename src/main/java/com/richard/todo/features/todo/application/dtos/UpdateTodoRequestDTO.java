package com.richard.todo.features.todo.application.dtos;

import com.richard.todo.features.todo.domain.enums.TodoPriorityEnum;
import jakarta.validation.constraints.Size;

public class UpdateTodoRequestDTO {
    @Size(max = 100, message = "Maximum is 100")
    private String name;

    @Size(max = 500, message = "Maximum is 100")
    private String description;

    private TodoPriorityEnum priority;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TodoPriorityEnum getPriority() {
        return priority;
    }
}