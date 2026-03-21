package com.taller.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.backend.model.RepairedArea;

public interface RepairedAreaRepository extends JpaRepository<RepairedArea, Long> {
    
}
