package com.taller.backend.mapper;

import java.util.List;

import com.taller.backend.dto.VehicleDTO;
import com.taller.backend.dto.WorkOrderDTO;
import com.taller.backend.model.Vehicle;

public class VehicleMapper {
    public static VehicleDTO toDTO(Vehicle entity) {
    // Convertimos la lista de WorkOrders (entidad) a WorkOrderDTO
    List<WorkOrderDTO> orderDTOs = null;
    if (entity.getWorkOrders() != null) {
        orderDTOs = entity.getWorkOrders().stream()
            .map(order -> {
                WorkOrderDTO woDto = new WorkOrderDTO();
                woDto.setId(order.getId());
                woDto.setGeneralDescription(order.getGeneralDescription());
                woDto.setEntryDate(order.getEntryDate());
                woDto.setExitDate(order.getExitDate());
                woDto.setVehicleId(entity.getId());
                return woDto;
            }).toList();
    }

        // Retornamos usando tu constructor con el nuevo parámetro al final
        return new VehicleDTO(
                entity.getId(),
                entity.getPatent(),
                entity.getMake(),
                entity.getModel(),
                entity.getYear(),
                entity.getOriginalColorCode(),
                orderDTOs // <--- El nuevo integrante
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
  /*public static VehicleDTO toDTO(Vehicle entity) {
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
    }*/