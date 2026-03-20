package com.taller.backend.mapper;

import java.util.ArrayList;
import java.util.List;

import com.taller.backend.dto.ColorAdjustmentDTO;
import com.taller.backend.dto.RepairedAreaDTO;
import com.taller.backend.dto.WorkOrderDTO;
import com.taller.backend.model.Vehicle;
import com.taller.backend.model.WorkOrder;

public class WorkOrderMapper {

    public static WorkOrderDTO toDTO(WorkOrder entity) {
        List<RepairedAreaDTO> areas = (entity.getRepairedAreas() != null) ? 
        entity.getRepairedAreas().stream().map(area -> new RepairedAreaDTO(
            area.getId(), 
            area.getAreaName(),
            area.getJobDetail()
        )).toList() : new ArrayList<>();

    // 2. Mapear ColorAdjustments (Entidad -> DTO)
    List<ColorAdjustmentDTO> adjustments = (entity.getColorAdjustments() != null) ? 
        entity.getColorAdjustments().stream().map(adj -> new ColorAdjustmentDTO(
            adj.getId(), 
            adj.getTintName(), 
            adj.getBaseColorCode(),
            adj.getPaintSupplier(),
            adj.getFinalFormula(),
            adj.getTouchUpDescription(),
            adj.getPrimerG1_G7(),
            adj.getNumberOfCoats()
        )).toList() : new ArrayList<>();
        return new WorkOrderDTO(
                entity.getId(),
                entity.getVehicle().getId(),
                entity.getGeneralDescription(),
                entity.getEntryDate(),
                entity.getExitDate(),
                areas,
                adjustments
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