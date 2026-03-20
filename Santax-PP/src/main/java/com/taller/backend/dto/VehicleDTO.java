package com.taller.backend.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Long id;

    private String patent;

    private String make;

    private String model;
    
    private Integer year;
    private String originalColorCode;

    private List<WorkOrderDTO> workOrders;
}
