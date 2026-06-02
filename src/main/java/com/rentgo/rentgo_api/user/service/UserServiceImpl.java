package com.rentgo.rentgo_api.user.service;


import com.rentgo.rentgo_api.common.exceptions.BusinessException;
import com.rentgo.rentgo_api.user.dto.CreateUserRequest;
import com.rentgo.rentgo_api.user.dto.UserResponse;
import com.rentgo.rentgo_api.user.entity.UserEntity;
import com.rentgo.rentgo_api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponse createUser(CreateUserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new BusinessException(
                    "A user with email " + request.getEmail() + " already exists"
            );
        }

        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        UserEntity savedUser = repository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
}