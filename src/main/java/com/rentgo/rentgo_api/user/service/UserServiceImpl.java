package com.rentgo.rentgo_api.user.service;


import com.rentgo.rentgo_api.common.exceptions.BusinessException;
import com.rentgo.rentgo_api.user.dto.CreateUserRequest;
import com.rentgo.rentgo_api.user.dto.UserResponse;
import com.rentgo.rentgo_api.user.entity.UserEntity;
import com.rentgo.rentgo_api.user.mapper.UserMapper;
import com.rentgo.rentgo_api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse createUser(CreateUserRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new BusinessException(
                    "A user with email " + request.getEmail() + " already exists"
            );
        }
        UserEntity user = mapper.toEntity(request);

        return mapper.toResponse(repository.save(user));
    }
}