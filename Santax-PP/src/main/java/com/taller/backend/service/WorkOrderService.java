package com.taller.backend.service;

import com.taller.backend.model.WorkOrder;
import com.taller.backend.model.Vehicle;
import com.taller.backend.repository.WorkOrderRepository;
import org.springframework.stereotype.Service;
import com.taller.backend.dto.WorkOrderDTO;
import com.taller.backend.repository.VehicleRepository;


import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final VehicleRepository vehicleRepository;

    public WorkOrderService(WorkOrderRepository workOrderRepository,
                            VehicleRepository vehicleRepository) {
        this.workOrderRepository = workOrderRepository;
        this.vehicleRepository = vehicleRepository;
    }

     public WorkOrderDTO save(WorkOrderDTO dto) {

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        WorkOrder workOrder = new WorkOrder();
        workOrder.setVehicle(vehicle);
        workOrder.setGeneralDescription(dto.getGeneralDescription());
        workOrder.setEntryDate(dto.getEntryDate());
        workOrder.setExitDate(dto.getExitDate());

        WorkOrder saved = workOrderRepository.save(workOrder);

        return mapToDTO(saved);
    }

    
    public List<WorkOrderDTO> findByVehicle(Long vehicleId) {

        List<WorkOrder> workOrders = workOrderRepository.findByVehicleId(vehicleId);

        return workOrders.stream()
                .map(this::mapToDTO)
                .toList();
    }

    
    private WorkOrderDTO mapToDTO(WorkOrder workOrder) {

        WorkOrderDTO dto = new WorkOrderDTO();

        dto.setId(workOrder.getId());
        dto.setVehicleId(workOrder.getVehicle().getId());
        dto.setGeneralDescription(workOrder.getGeneralDescription());
        dto.setEntryDate(workOrder.getEntryDate());
        dto.setExitDate(workOrder.getExitDate());

        return dto;
    }

    public WorkOrderDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}




