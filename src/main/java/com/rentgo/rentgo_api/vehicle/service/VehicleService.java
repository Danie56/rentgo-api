package com.rentgo.rentgo_api.vehicle.service;

import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import com.rentgo.rentgo_api.vehicle.dto.CreateVehicleRequest;
import com.rentgo.rentgo_api.vehicle.dto.VehicleResponse;

import java.util.List;

public interface VehicleService {
    VehicleResponse createVehicle(CreateVehicleRequest request);
    List<VehicleResponse> getAllVehiclesByStatus(VehicleStatus status);
    VehicleResponse enableVehicle(String plate);

}
