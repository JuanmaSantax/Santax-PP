package com.taller.backend.service;

import com.taller.backend.model.WorkOrder;
import com.taller.backend.model.Vehicle;
import com.taller.backend.repository.WorkOrderRepository;
import org.springframework.stereotype.Service;
import com.taller.backend.dto.WorkOrderDTO;
import com.taller.backend.mapper.WorkOrderMapper;
import com.taller.backend.repository.VehicleRepository;
import java.util.stream.Collectors;

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

    public List<WorkOrderDTO> findAll() {
        return workOrderRepository.findAll()
                .stream()
                .map(WorkOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    public WorkOrderDTO findById(Long id) {
        WorkOrder workOrder = workOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkOrder not found"));

        return WorkOrderMapper.toDTO(workOrder);
    }

    public WorkOrderDTO save(WorkOrderDTO dto) {

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        WorkOrder workOrder = WorkOrderMapper.toEntity(dto, vehicle);

        WorkOrder saved = workOrderRepository.save(workOrder);

        return WorkOrderMapper.toDTO(saved);
    }
}

