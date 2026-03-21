package com.taller.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.backend.dto.ColorAdjustmentDTO;
import com.taller.backend.model.ColorAdjustment;
import com.taller.backend.model.WorkOrder;
import com.taller.backend.repository.WorkOrderRepository;
import com.taller.backend.repository.colorAdjustmentRepository;

@Service
public class colorAdjustmentService {
    @Autowired
    private colorAdjustmentRepository repository;

    @Autowired
    private WorkOrderRepository workOrderRepository;

    public ColorAdjustmentDTO save(ColorAdjustmentDTO dto) {
        WorkOrder order = workOrderRepository.findById(dto.getWorkOrderId())
            .orElseThrow(() -> new RuntimeException("WorkOrder not found with id: " + dto.getWorkOrderId()));

        ColorAdjustment color = new ColorAdjustment();
        color.setTintName(dto.getTintName());
        color.setWorkOrder(order);
        color.setBaseColorCode(dto.getBaseColorCode());
        color.setPaintSupplier(dto.getPaintSupplier());
        color.setFinalFormula(dto.getFinalFormula());
        color.setTouchUpDescription(dto.getTouchUpDescription());
        color.setPrimerG1_G7(dto.getPrimerG1_G7());
        color.setNumberOfCoats(dto.getNumberOfCoats());

        ColorAdjustment saved = repository.save(color);
        return new ColorAdjustmentDTO(
            saved.getId(),
            saved.getWorkOrder().getId(),
            saved.getTintName(),
            saved.getBaseColorCode(),
            saved.getPaintSupplier(),
            saved.getFinalFormula(),
            saved.getTouchUpDescription(),
            saved.getPrimerG1_G7(),
            saved.getNumberOfCoats()
        );
    }

}
