package com.richard.todo.features.todo.domain.exceptions;

public class TodoNotFoundExeption extends RuntimeException {
    public TodoNotFoundExeption(String message) {
        super(message);
    }
}