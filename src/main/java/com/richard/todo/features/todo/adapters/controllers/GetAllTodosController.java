package com.richard.todo.features.todo.adapters.controllers;

import com.richard.todo.features.todo.application.dtos.TodoResponseDTO;
import com.richard.todo.features.todo.application.services.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class GetAllTodosController {
    private final TodoService todoService;

    public GetAllTodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public List<TodoResponseDTO> getAllTodos() {
        return this.todoService.getAllTodos();
    }
}
