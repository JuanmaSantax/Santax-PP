package com.taller.backend.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "color_adjustment")
public class ColorAdjustment { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String tintName;

    @ManyToOne
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    @Column(nullable = false)
    private String baseColorCode;

    @Column(nullable = false)
    private String paintSupplier;

    @Column(nullable = false)
    private String finalFormula;

    // hasDamero? 
    private String touchUpDescription; 
    private String primerG1_G7;
    private int numberOfCoats;
}
