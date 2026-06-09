package com.rentgo.rentgo_api.vehicle.controller;


import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import com.rentgo.rentgo_api.user.dto.CreateUserRequest;
import com.rentgo.rentgo_api.user.dto.UserResponse;
import com.rentgo.rentgo_api.user.service.UserService;
import com.rentgo.rentgo_api.vehicle.dto.ChangeVehicleStatusRequest;
import com.rentgo.rentgo_api.vehicle.dto.CreateVehicleRequest;
import com.rentgo.rentgo_api.vehicle.dto.VehicleResponse;
import com.rentgo.rentgo_api.vehicle.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @PostMapping
    public ResponseEntity<VehicleResponse> create(
            @Valid @RequestBody CreateVehicleRequest request
    ) {

        return ResponseEntity.ok(
                service.createVehicle(request)
        );
    }
    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getActiveVehicles() {

        return ResponseEntity.ok(
                service.getAllVehiclesByStatus(VehicleStatus.AVAILABLE)
        );
    }
    @PatchMapping("/{plate}/change-status")
    public  ResponseEntity<VehicleResponse>changeStatus(@PathVariable String plate,@Valid @RequestBody ChangeVehicleStatusRequest request){

        return ResponseEntity.ok(service.changeStatus(plate,request));
    }
}