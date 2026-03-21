package com.taller.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taller.backend.model.ColorAdjustment;

@Repository
public interface colorAdjustmentRepository extends JpaRepository<ColorAdjustment, Long> {
    
}
