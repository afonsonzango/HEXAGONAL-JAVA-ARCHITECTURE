package com.richard.todo.features.user.adapters.controllers;

import com.richard.todo.features.user.application.dtos.UserResponseDTO;
import com.richard.todo.features.user.application.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class GetAllUsersController {
    private final UserService userService;

    public GetAllUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<UserResponseDTO> getAllUser() {
        return this.userService.getUserAll();
    }
}