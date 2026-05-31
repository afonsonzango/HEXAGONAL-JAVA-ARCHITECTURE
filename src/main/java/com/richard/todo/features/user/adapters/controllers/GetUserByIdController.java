package com.richard.todo.features.user.adapters.controllers;

import com.richard.todo.features.user.application.dtos.UserResponseDTO;
import com.richard.todo.features.user.application.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class GetUserByIdController {
    private final UserService userService;

    public GetUserByIdController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public UserResponseDTO getUserById(
        @PathVariable UUID id
    ) {
        return this.userService.getUserById(id);
    }
}