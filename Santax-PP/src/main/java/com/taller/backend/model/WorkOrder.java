package com.taller.backend.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "work_order")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //Muchas ordenes un vehiculo
    @JoinColumn(name = "vehicle_id", nullable = false)
    @JsonBackReference//Evita que la orden vuelva a llamar al vehiculo y genere un ciclo infinito
    private Vehicle vehicle;

    private String generalDescription;

    @Column(nullable = false)
    private LocalDate entryDate; 

    private LocalDate exitDate; 

    // Una orden de trabajo puede tener varias áreas reparadas y ajustes de color
    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RepairedArea> repairedAreas = new ArrayList<>();

    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ColorAdjustment> colorAdjustments = new ArrayList<>();
}