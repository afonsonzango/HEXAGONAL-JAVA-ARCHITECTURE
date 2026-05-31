package com.richard.todo.features.user.application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Maximum is 100")
    private String name;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Maximum is 100")
    private String email;

    @NotBlank(message = "Name is required")
    @Size(max = 100, min = 8, message = "Maximum is 100")
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
