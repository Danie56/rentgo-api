package com.rentgo.rentgo_api.vehicle.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleRequest {
    @NotBlank(message = "Plate is required")
    @Size(max = 20, message = "Plate cannot exceed 20 characters")
    private String plate;

    @NotBlank(message = "Brand is required")
    @Size(max = 100, message = "Brand cannot exceed 100 characters")
    private String brand;

    @NotBlank(message = "Model is required")
    @Size(max = 100, message = "Model cannot exceed 100 characters")
    private String model;

    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be greater than 1900")
    @Max(value = 2100, message = "Year must be less than or equal to 2100")
    private Integer year;

    @NotBlank(message = "Color is required")
    @Size(max = 50, message = "Color cannot exceed 50 characters")
    private String color;

    @NotNull(message = "Daily price is required")
    @DecimalMin(value = "0.01", message = "Daily price must be greater than 0")
    @Digits(integer = 8, fraction = 2,
            message = "Daily price must have up to 8 integer digits and 2 decimal places")
    private BigDecimal dailyPrice;
}
