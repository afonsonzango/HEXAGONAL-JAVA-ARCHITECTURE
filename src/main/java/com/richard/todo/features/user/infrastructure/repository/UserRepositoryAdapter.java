package com.richard.todo.features.user.infrastructure.repository;


import com.richard.todo.features.user.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryAdapter extends JpaRepository<UserEntity, UUID> {}