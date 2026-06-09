package com.rentgo.rentgo_api.vehicle.dto;

import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeVehicleStatusRequest {

    @NotNull(message = "Status is required")
    private VehicleStatus status;
}
