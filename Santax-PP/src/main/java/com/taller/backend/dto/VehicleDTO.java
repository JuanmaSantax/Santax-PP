package com.taller.backend.dto;
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
}
