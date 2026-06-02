package com.rentgo.rentgo_api.user.service;

import com.rentgo.rentgo_api.user.dto.CreateUserRequest;
import com.rentgo.rentgo_api.user.dto.UserResponse;

public interface UserService {
    UserResponse createUser(CreateUserRequest request);
}
