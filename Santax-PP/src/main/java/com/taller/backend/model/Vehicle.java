package com.taller.backend.model;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String patent;

    @Column(nullable = false)
    private String make; 
    @Column(nullable = false)
    private String model;

    private Integer year;

    private String originalColorCode; 

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL  , orphanRemoval = true)
    @JsonManagedReference
    private List<WorkOrder> workOrders =new ArrayList<>();
}