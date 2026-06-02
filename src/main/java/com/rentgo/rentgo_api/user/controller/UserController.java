package com.rentgo.rentgo_api.user.controller;


import com.rentgo.rentgo_api.user.dto.CreateUserRequest;
import com.rentgo.rentgo_api.user.dto.UserResponse;
import com.rentgo.rentgo_api.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Valid @RequestBody CreateUserRequest request
    ) {

        return ResponseEntity.ok(
                service.createUser(request)
        );
    }
}