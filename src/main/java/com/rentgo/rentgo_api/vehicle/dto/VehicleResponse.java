package com.rentgo.rentgo_api.vehicle.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VehicleResponse {
    private String model;
    private String plate;
}
