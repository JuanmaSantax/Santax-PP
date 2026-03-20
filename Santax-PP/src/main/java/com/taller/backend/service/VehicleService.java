package com.taller.backend.service;

import com.taller.backend.dto.VehicleDTO;
import com.taller.backend.model.Vehicle;
import com.taller.backend.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.taller.backend.mapper.VehicleMapper;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

   public Page<VehicleDTO> findAll(Pageable pageable) {
    return vehicleRepository
            .findAll(pageable)
            .map(VehicleMapper::toDTO);
    }

    public VehicleDTO findById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        return VehicleMapper.toDTO(vehicle);
    }

    public VehicleDTO save(VehicleDTO dto) {
        Vehicle vehicle = VehicleMapper.toEntity(dto);
        Vehicle saved = vehicleRepository.save(vehicle);
        return VehicleMapper.toDTO(saved);
    }

    public VehicleDTO update(Long id, VehicleDTO dto) {

        Vehicle existing = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        existing.setMake(dto.getMake());
        existing.setModel(dto.getModel());
        existing.setPatent(dto.getPatent());
        existing.setYear(dto.getYear());
        existing.setOriginalColorCode(dto.getOriginalColorCode());

        Vehicle updated = vehicleRepository.save(existing);

        return VehicleMapper.toDTO(updated);
    }

    public void deleteById(Long id) { 
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehicle not found");
        }
        vehicleRepository.deleteById(id);
    }
}