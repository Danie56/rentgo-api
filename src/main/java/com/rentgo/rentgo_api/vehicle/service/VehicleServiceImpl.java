package com.rentgo.rentgo_api.vehicle.service;


import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import com.rentgo.rentgo_api.common.exceptions.BusinessException;
import com.rentgo.rentgo_api.common.exceptions.ResourceNotFoundException;
import com.rentgo.rentgo_api.vehicle.dto.ChangeVehicleStatusRequest;
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
    public VehicleResponse changeStatus(String plate, ChangeVehicleStatusRequest request) {
        VehicleEntity vehicle = repository.findByPlate(plate).orElseThrow(()-> new ResourceNotFoundException( "Vehicle with id " + plate + " not found"));
        vehicle.setStatus(request.getStatus());

        return mapper.toResponse(repository.save(vehicle));
    }
}