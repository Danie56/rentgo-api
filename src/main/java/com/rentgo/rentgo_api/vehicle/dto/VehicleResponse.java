package com.rentgo.rentgo_api.vehicle.dto;

import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VehicleResponse {
    private String model;
    private String plate;
    private VehicleStatus status;
}
