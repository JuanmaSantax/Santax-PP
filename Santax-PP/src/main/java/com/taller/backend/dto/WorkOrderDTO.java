package com.taller.backend.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderDTO {
    
    private Long id;
    private Long vehicleId;
    private String generalDescription;
    private LocalDate entryDate;
    private LocalDate exitDate;

    private List<RepairedAreaDTO> repairedAreas;
    private List<ColorAdjustmentDTO> colorAdjustments;
}
