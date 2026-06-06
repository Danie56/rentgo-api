package com.rentgo.rentgo_api.vehicle.entity;

import com.rentgo.rentgo_api.common.entity.AuditableEntity;
import com.rentgo.rentgo_api.common.enums.Role;
import com.rentgo.rentgo_api.common.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name="vehicles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true,length = 20)
    private String plate;
    @Column(length = 100, nullable = false)
    private String brand;
    @Column(length = 100,nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false,length = 50)
    private String color;
    @Column(name = "daily_price",nullable = false,precision = 10, scale = 2)
    private BigDecimal dailyPrice;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleStatus status;

}
