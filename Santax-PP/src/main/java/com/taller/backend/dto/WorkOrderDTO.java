package com.taller.backend.dto;

import java.time.LocalDate;

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
}
