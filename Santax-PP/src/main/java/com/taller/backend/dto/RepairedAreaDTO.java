package com.taller.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepairedAreaDTO {
    private Long id;

    private String areaName;
    private String jobDetail;
    private Long workOrderId;
    
}
