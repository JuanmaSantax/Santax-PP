package com.taller.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Long id;

   // @NotBlank(message = "Patent is required")
   // @Size(min = 6, max = 10, message = "Plate must be between 6 and 10 characters")
    private String patent;

   // @NotBlank(message = "Make is required")
    private String make;

    //@NotBlank(message = "Model is required")
    private String model;
    
   // @NotNull(message = "Year is required")
    private Integer year;
    private String originalColorCode;
}
