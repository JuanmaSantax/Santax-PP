package com.taller.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.backend.dto.ColorAdjustmentDTO;
import com.taller.backend.service.colorAdjustmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/colorAdjustment")
@CrossOrigin(origins = "http://localhost:5173")
public class colorAdjustmentController {

    @Autowired
    private colorAdjustmentService colorAdjustmentService;

    @PostMapping
    public ResponseEntity<ColorAdjustmentDTO> addColorAdjustment(@RequestBody ColorAdjustmentDTO dto){
        return ResponseEntity.ok(colorAdjustmentService.save(dto));
    } 
    
}
