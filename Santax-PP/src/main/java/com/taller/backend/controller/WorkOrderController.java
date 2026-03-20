package com.taller.backend.controller;
import com.taller.backend.service.WorkOrderService;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taller.backend.dto.WorkOrderDTO;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/workorders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

  /*  @GetMapping
    public List<WorkOrderDTO> getAllWorkOrders() {
        return workOrderService.findAll();
    }*/

    @GetMapping("/{id}")
    public WorkOrderDTO getWorkOrderById(@PathVariable Long id) {
        return workOrderService.findById(id);
    }

    @PostMapping
    public WorkOrderDTO createWorkOrder(@RequestBody WorkOrderDTO dto) {
        return workOrderService.save(dto);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<WorkOrderDTO> getWorkOrdersByVehicleId(@PathVariable Long vehicleId) {
        return workOrderService.findByVehicle(vehicleId);
    }
}
