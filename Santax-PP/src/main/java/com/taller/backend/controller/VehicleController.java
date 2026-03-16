package com.taller.backend.controller;
import com.taller.backend.service.VehicleService;

import com.taller.backend.dto.VehicleDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

   @GetMapping
    public Page<VehicleDTO> findAll(Pageable pageable) {
    return vehicleService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable Long id) {
        return vehicleService.findById(id);
    }

    @PostMapping
    public VehicleDTO createVehicle(@RequestBody VehicleDTO dto) {
        return vehicleService.save(dto);
    }

    @PutMapping("/{id}")
    public VehicleDTO updateVehicle(@PathVariable Long id,
                                    @RequestBody VehicleDTO dto) {
        return vehicleService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteById(id);
    }
}