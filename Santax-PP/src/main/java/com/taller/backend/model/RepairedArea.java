package com.taller.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;   

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "repaired_area")
public class RepairedArea { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String areaName;

    private String jobDetail;

    @ManyToOne 
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;
}

