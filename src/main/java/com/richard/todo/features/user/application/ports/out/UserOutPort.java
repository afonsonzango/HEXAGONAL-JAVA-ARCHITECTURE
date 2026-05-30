package com.richard.todo.features.user.application.ports.out;

import com.richard.todo.features.user.domain.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserOutPort {
    UserModel save(UserModel user);

    Optional<UserModel> findById(UUID id);

    Optional<UserModel> findByEmail(String email);

    List<UserModel> findAll();

    void deleteById(UUID id);

    boolean existsByEmail(String email);
}