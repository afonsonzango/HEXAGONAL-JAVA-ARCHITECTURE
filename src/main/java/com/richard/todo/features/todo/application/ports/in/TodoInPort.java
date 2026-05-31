package com.richard.todo.features.todo.application.ports.in;

import com.richard.todo.features.todo.application.dtos.CreateTodoRequestDTO;
import com.richard.todo.features.todo.application.dtos.TodoResponseDTO;
import com.richard.todo.features.todo.application.dtos.UpdateTodoRequestDTO;

import java.util.List;
import java.util.UUID;

public interface TodoInPort {
    TodoResponseDTO createTodo(CreateTodoRequestDTO request);

    TodoResponseDTO getTodoById(UUID id);

    List<TodoResponseDTO> getAllTodos();

    List<TodoResponseDTO> getTodoByUserId(UUID id);

    TodoResponseDTO updateTodo(UpdateTodoRequestDTO request);

    void deleteTodo(UUID id);
}