package com.rentgo.rentgo_api.vehicle.repository;

import com.rentgo.rentgo_api.user.entity.UserEntity;
import com.rentgo.rentgo_api.vehicle.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {
    boolean existsByPlate(String plate);
}
