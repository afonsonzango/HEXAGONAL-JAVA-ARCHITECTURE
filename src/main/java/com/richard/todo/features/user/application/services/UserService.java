package com.richard.todo.features.user.application.services;

import com.richard.todo.features.user.application.dtos.CreateUserRequestDTO;
import com.richard.todo.features.user.application.dtos.UpdateUserRequestDTO;
import com.richard.todo.features.user.application.dtos.UserResponseDTO;
import com.richard.todo.features.user.application.ports.in.UserInPort;
import com.richard.todo.features.user.domain.exceptions.EmailAlreadyExistsException;
import com.richard.todo.features.user.domain.exceptions.UserNotFoundExeption;
import com.richard.todo.features.user.domain.mappers.UserMappers;
import com.richard.todo.features.user.domain.model.UserModel;
import com.richard.todo.features.user.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserInPort {
    private final UserMappers userMappers;
    private final UserRepository userRepository;

    public UserService(UserMappers userMappers, UserRepository userRepository) {
        this.userMappers = userMappers;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(CreateUserRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        UserModel user = new UserModel();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return this.userMappers.toResponseDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getUserById(UUID id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundExeption(id.toString()));
        return userMappers.toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getUserAll() {
        return userRepository.findAll().stream().map(userMappers::toResponseDTO).toList();
    }

    @Override
    public UserResponseDTO updateUser(UpdateUserRequestDTO request) {
        return null;
    }

    @Override
    public void deleteUser(UUID id) {
    }
}
