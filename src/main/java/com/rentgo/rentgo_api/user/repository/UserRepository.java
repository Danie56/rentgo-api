package com.rentgo.rentgo_api.user.repository;

import com.rentgo.rentgo_api.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
}
