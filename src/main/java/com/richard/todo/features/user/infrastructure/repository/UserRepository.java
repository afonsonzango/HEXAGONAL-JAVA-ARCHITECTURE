package com.richard.todo.features.user.infrastructure.repository;

import com.richard.todo.features.user.application.ports.out.UserOutPort;
import com.richard.todo.features.user.domain.mappers.UserMappers;
import com.richard.todo.features.user.domain.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository implements UserOutPort {
    private final UserRepositoryAdapter userRepositoryAdapter;
    private final UserMappers userMappers;

    public UserRepository(UserRepositoryAdapter userRepositoryAdapter, UserMappers userMappers) {
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userMappers = userMappers;
    }

    @Override
    public UserModel save(UserModel user) {
        return this.userMappers.toModel(userRepositoryAdapter.save(this.userMappers.toEntity(user)));
    }

    @Override
    public Optional<UserModel> findById(UUID id) {
        return this.userRepositoryAdapter.findById(id).map(userMappers::toModel);
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        return this.userRepositoryAdapter.findByEmail(email).map(userMappers::toModel);
    }

    @Override
    public List<UserModel> findAll() {
        return this.userRepositoryAdapter.findAll().stream().map(userMappers::toModel).toList();
    }

    @Override
    public void deleteById(UUID id) {
        this.userRepositoryAdapter.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepositoryAdapter.existsByEmail(email);
    }
}