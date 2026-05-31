package com.richard.todo.features.todo.adapters.controllers;

import com.richard.todo.features.todo.application.dtos.TodoResponseDTO;
import com.richard.todo.features.todo.application.services.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
public class GetTodoByIdController {
    private final TodoService todoService;

    public GetTodoByIdController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public TodoResponseDTO getTodosById(
            @PathVariable UUID id
    ) {
        return this.todoService.getTodoById(id);
    }
}
