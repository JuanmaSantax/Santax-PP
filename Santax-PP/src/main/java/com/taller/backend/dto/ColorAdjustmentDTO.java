package com.taller.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColorAdjustmentDTO {
    private Long id;

    private String tintName;
    private String baseColorCode;
    private String paintSupplier;
    private String finalFormula;

    private String touchUpDescription;
    private String primerG1_G7;
    private int numberOfCoats;

}
