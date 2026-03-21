package com.taller.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.backend.dto.RepairedAreaDTO;
import com.taller.backend.model.RepairedArea;
import com.taller.backend.model.WorkOrder;
import com.taller.backend.repository.RepairedAreaRepository;
import com.taller.backend.repository.WorkOrderRepository;

@Service
public class RepairedAreaService {
    
    @Autowired
    private RepairedAreaRepository repository;

    @Autowired
    private WorkOrderRepository workOrderRepository;

    public RepairedAreaDTO save(RepairedAreaDTO dto) {
        WorkOrder order = workOrderRepository.findById(dto.getWorkOrderId())
            .orElseThrow(() -> new RuntimeException("WorkOrder not found with id: " + dto.getWorkOrderId()));
        
        RepairedArea area = new RepairedArea();
        area.setAreaName(dto.getAreaName());
        area.setJobDetail(dto.getJobDetail());
        area.setWorkOrder(order);

        RepairedArea saved = repository.save(area);

        return new RepairedAreaDTO(saved.getId(), saved.getAreaName(), saved.getJobDetail(), order.getId());
    }

}
