package com.rentgo.rentgo_api.vehicle.mapper;


import com.rentgo.rentgo_api.vehicle.dto.CreateVehicleRequest;
import com.rentgo.rentgo_api.vehicle.dto.VehicleResponse;
import com.rentgo.rentgo_api.vehicle.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VehicleMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    VehicleEntity toEntity(CreateVehicleRequest request);

    VehicleResponse toResponse(VehicleEntity entity);

}
