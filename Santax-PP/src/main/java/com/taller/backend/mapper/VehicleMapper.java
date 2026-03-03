package com.taller.backend.mapper;

import com.taller.backend.dto.VehicleDTO;
import com.taller.backend.model.Vehicle;

public class VehicleMapper {

    public static VehicleDTO toDTO(Vehicle entity) {
        return new VehicleDTO(
                entity.getId(),
                entity.getPatent(),
                entity.getMake(),
                entity.getModel(),
                entity.getYear(),
                entity.getOriginalColorCode()
        );
    }

    public static Vehicle toEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(dto.getId());
        vehicle.setPatent(dto.getPatent());
        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setOriginalColorCode(dto.getOriginalColorCode());
        return vehicle;
    }
}
