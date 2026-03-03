package com.taller.backend.model;
import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    private String generalDescription;

    @Column(nullable = false)
    private LocalDate entryDate; 

    private LocalDate exitDate; 
}