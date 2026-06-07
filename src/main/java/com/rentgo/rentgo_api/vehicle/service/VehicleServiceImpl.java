package com.rentgo.rentgo_api.vehicle.service;


import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import com.rentgo.rentgo_api.common.exceptions.BusinessException;
import com.rentgo.rentgo_api.common.exceptions.ResourceNotFoundException;
import com.rentgo.rentgo_api.user.dto.CreateUserRequest;
import com.rentgo.rentgo_api.user.dto.UserResponse;
import com.rentgo.rentgo_api.user.entity.UserEntity;
import com.rentgo.rentgo_api.user.mapper.UserMapper;
import com.rentgo.rentgo_api.user.repository.UserRepository;
import com.rentgo.rentgo_api.user.service.UserService;
import com.rentgo.rentgo_api.vehicle.dto.CreateVehicleRequest;
import com.rentgo.rentgo_api.vehicle.dto.VehicleResponse;
import com.rentgo.rentgo_api.vehicle.entity.VehicleEntity;
import com.rentgo.rentgo_api.vehicle.mapper.VehicleMapper;
import com.rentgo.rentgo_api.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    @Override
    public VehicleResponse createVehicle(CreateVehicleRequest request) {

        if (repository.existsByPlate(request.getPlate())) {
            throw new BusinessException(
                    "A vehicle with plate " + request.getPlate() + " already exists"
            );
        }
        VehicleEntity vehicle = mapper.toEntity(request);
        vehicle.setStatus(VehicleStatus.AVAILABLE);

        return mapper.toResponse(repository.save(vehicle));
    }

    @Override
    public List<VehicleResponse> getAllVehiclesByStatus(VehicleStatus status) {
        return repository.findByStatus(status).stream().map(mapper::toResponse).toList();
    }

    @Override
    public VehicleResponse enableVehicle(String plate) {
        VehicleEntity vehicle = repository.findByPlate(plate).orElseThrow(()-> new ResourceNotFoundException( "Vehicle with id " + plate + " not found"));
        vehicle.setStatus(VehicleStatus.OUT_OF_SERVICE);

        return mapper.toResponse(repository.save(vehicle));
    }
}