package com.taller.backend.mapper;

import com.taller.backend.dto.WorkOrderDTO;
import com.taller.backend.model.Vehicle;
import com.taller.backend.model.WorkOrder;

public class WorkOrderMapper {

    public static WorkOrderDTO toDTO(WorkOrder entity) {
        return new WorkOrderDTO(
                entity.getId(),
                entity.getVehicle().getId(),
                entity.getGeneralDescription(),
                entity.getEntryDate(),
                entity.getExitDate()
        );
    }

    public static WorkOrder toEntity(WorkOrderDTO dto, Vehicle vehicle) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setId(dto.getId());
        workOrder.setVehicle(vehicle);
        workOrder.setGeneralDescription(dto.getGeneralDescription());
        workOrder.setEntryDate(dto.getEntryDate());
        workOrder.setExitDate(dto.getExitDate());
        return workOrder;
    }
}