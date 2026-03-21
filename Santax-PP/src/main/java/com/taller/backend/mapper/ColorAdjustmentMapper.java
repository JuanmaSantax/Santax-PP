package com.taller.backend.mapper;

import com.taller.backend.dto.ColorAdjustmentDTO;
import com.taller.backend.model.ColorAdjustment;
import com.taller.backend.model.WorkOrder;

public class ColorAdjustmentMapper {
    public static ColorAdjustmentDTO toDTO(ColorAdjustment entity) {
        if (entity == null) return null;
        return new ColorAdjustmentDTO(
            entity.getId(),
            entity.getWorkOrder() != null ? entity.getWorkOrder().getId() : null, // IMPORTANTE
            entity.getTintName(),
            entity.getBaseColorCode(),
            entity.getPaintSupplier(),
            entity.getFinalFormula(),
            entity.getTouchUpDescription(),
            entity.getPrimerG1_G7(),
            entity.getNumberOfCoats()
        );
    }

    public static ColorAdjustment toEntity(ColorAdjustmentDTO dto, WorkOrder workOrder) {
        if (dto == null) return null;
        ColorAdjustment entity = new ColorAdjustment();
        entity.setId(dto.getId());
        entity.setTintName(dto.getTintName());
        entity.setBaseColorCode(dto.getBaseColorCode());
        entity.setPaintSupplier(dto.getPaintSupplier());
        entity.setFinalFormula(dto.getFinalFormula());
        entity.setTouchUpDescription(dto.getTouchUpDescription());
        entity.setPrimerG1_G7(dto.getPrimerG1_G7());
        entity.setNumberOfCoats(dto.getNumberOfCoats());
        entity.setWorkOrder(workOrder);
        return entity;
    }
}