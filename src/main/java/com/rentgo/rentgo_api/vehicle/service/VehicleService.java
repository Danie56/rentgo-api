package com.rentgo.rentgo_api.vehicle.service;

import com.rentgo.rentgo_api.vehicle.dto.CreateVehicleRequest;
import com.rentgo.rentgo_api.vehicle.dto.VehicleResponse;

public interface VehicleService {
    VehicleResponse createVehicle(CreateVehicleRequest request);
}
