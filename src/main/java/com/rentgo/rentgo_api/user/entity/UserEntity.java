package com.rentgo.rentgo_api.user.entity;

import com.rentgo.rentgo_api.common.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    private UUID id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Column(name = "create_at",nullable = false)
    private LocalDateTime crateAt;
    @Column(name = "update_at",nullable = false)
    private LocalDateTime updateAt;




}
