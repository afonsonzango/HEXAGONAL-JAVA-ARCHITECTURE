package com.richard.todo.features.user.adapters.controllers;

import com.richard.todo.features.user.application.dtos.CreateUserRequestDTO;
import com.richard.todo.features.user.application.dtos.UserResponseDTO;
import com.richard.todo.features.user.application.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class CreateUserController {
    private final UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(
            @Valid @RequestBody CreateUserRequestDTO request
    ) {
        return this.userService.createUser(request);
    }
}