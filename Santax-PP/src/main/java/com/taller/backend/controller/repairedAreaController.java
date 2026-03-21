package com.taller.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller.backend.dto.RepairedAreaDTO;
import com.taller.backend.service.RepairedAreaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("repairedAreas")
@CrossOrigin(origins = "http://localhost:5173")
public class repairedAreaController {
    @Autowired
    private RepairedAreaService repairedAreaService;

    @PostMapping 
    public ResponseEntity<RepairedAreaDTO> addArea(@RequestBody RepairedAreaDTO dto){
        return ResponseEntity.ok(repairedAreaService.save(dto));
    }
    
}
