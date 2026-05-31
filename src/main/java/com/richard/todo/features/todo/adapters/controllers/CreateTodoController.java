package com.richard.todo.features.todo.adapters.controllers;

import com.richard.todo.features.todo.application.dtos.CreateTodoRequestDTO;
import com.richard.todo.features.todo.application.dtos.TodoResponseDTO;
import com.richard.todo.features.todo.application.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class CreateTodoController {
    private final TodoService todoService;

    public CreateTodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoResponseDTO createTodo(
            @Valid @RequestBody CreateTodoRequestDTO request
    ) {
        return this.todoService.createTodo(request);
    }
}