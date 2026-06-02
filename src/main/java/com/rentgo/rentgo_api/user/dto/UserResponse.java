package com.rentgo.rentgo_api.user.dto;

import com.rentgo.rentgo_api.common.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private Role role;
}