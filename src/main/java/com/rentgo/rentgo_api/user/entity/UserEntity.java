package com.rentgo.rentgo_api.user.entity;

import com.rentgo.rentgo_api.common.entity.AuditableEntity;
import com.rentgo.rentgo_api.common.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name",nullable = false,length = 100)
    private String firstName;
    @Column(name = "last_name",nullable = false,length = 100)
    private String lastName;
    @Column(name = "email",unique = true,length = 255)
    private String email;
    @Column(nullable = false,length = 255)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;





}
