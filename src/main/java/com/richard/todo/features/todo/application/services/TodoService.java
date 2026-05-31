package com.richard.todo.features.todo.application.services;

import com.richard.todo.features.todo.application.dtos.CreateTodoRequestDTO;
import com.richard.todo.features.todo.application.dtos.TodoResponseDTO;
import com.richard.todo.features.todo.application.dtos.UpdateTodoRequestDTO;
import com.richard.todo.features.todo.application.ports.in.TodoInPort;
import com.richard.todo.features.todo.domain.exceptions.TodoNotFoundExeption;
import com.richard.todo.features.todo.domain.mappers.TodoMappers;
import com.richard.todo.features.todo.domain.model.TodoModel;
import com.richard.todo.features.todo.infrastructure.repository.TodoRepository;
import com.richard.todo.features.user.domain.exceptions.UserNotFoundExeption;
import com.richard.todo.features.user.domain.model.UserModel;
import com.richard.todo.features.user.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService implements TodoInPort {
    private final TodoMappers todoMappers;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    public TodoService(TodoMappers todoMappers, TodoRepository todoRepository, UserRepository userRepository) {
        this.todoMappers = todoMappers;
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TodoResponseDTO createTodo(CreateTodoRequestDTO request) {
        UserModel user = userRepository.findById((request.getUserId()))
                .orElseThrow(() -> new UserNotFoundExeption(request.getUserId().toString()));

        TodoModel todo = new TodoModel();
        todo.setName(request.getName());
        todo.setPriority(request.getPriority());
        todo.setDescription(request.getDescription());
        todo.setUser(user);

        return todoMappers.toResponseDTO(todoRepository.save(todo));
    }

    @Override
    public TodoResponseDTO getTodoById(UUID id) {
        TodoModel todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundExeption(id.toString()));

        return todoMappers.toResponseDTO(todo);
    }

    @Override
    public List<TodoResponseDTO> getAllTodos() {
        return todoRepository.findAll().stream().map(todoMappers::toResponseDTO).toList();
    }

    @Override
    public List<TodoResponseDTO> getTodoByUserId(UUID id) {
        this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundExeption(id.toString()));
        return this.todoRepository.findByUserId(id).stream().map(todoMappers::toResponseDTO).toList();
    }

    @Override
    public TodoResponseDTO updateTodo(UpdateTodoRequestDTO request) {
        return null;
    }

    @Override
    public void deleteTodo(UUID id) {
    }
}
