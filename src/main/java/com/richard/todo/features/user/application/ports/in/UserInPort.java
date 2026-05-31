package com.richard.todo.features.user.application.ports.in;

import com.richard.todo.features.user.application.dtos.CreateUserRequestDTO;
import com.richard.todo.features.user.application.dtos.UpdateUserRequestDTO;
import com.richard.todo.features.user.application.dtos.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserInPort {
    UserResponseDTO createUser(CreateUserRequestDTO request);

    UserResponseDTO getUserById(UUID id);

    List<UserResponseDTO> getUserAll();

    UserResponseDTO updateUser(UpdateUserRequestDTO request);

    void deleteUser(UUID id);
}