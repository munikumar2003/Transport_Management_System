package com.example.tms.service;

import com.example.tms.dto.TransporterDto;
import com.example.tms.entity.Transporter;
import com.example.tms.repository.TransporterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransporterService {

    private final TransporterRepository transporterRepository;

    public TransporterService(TransporterRepository transporterRepository) {
        this.transporterRepository = transporterRepository;
    }

    public Transporter createTransporter(TransporterDto transporterDto) {
        Transporter transporter = new Transporter();
        transporter.setCompanyName(transporterDto.companyName());
        transporter.setRating(transporterDto.rating());
        transporter.setAvailableTrucks(transporterDto.availableTrucks());
        return transporterRepository.save(transporter);
    }

    public List<Transporter> getAllTransporters() {
        return transporterRepository.findAll();
    }

    public Transporter getTransporterById(UUID id) {
        return transporterRepository.findById(id).orElse(null);
    }

    public Transporter updateTransporter(UUID id, TransporterDto transporterDto) {
        Transporter existingTransporter = transporterRepository.findById(id).orElse(null);
        if (existingTransporter != null) {
            existingTransporter.setCompanyName(transporterDto.companyName());
            existingTransporter.setRating(transporterDto.rating());
            existingTransporter.setAvailableTrucks(transporterDto.availableTrucks());
            return transporterRepository.save(existingTransporter);
        }
        return null;
    }

    public void deleteTransporter(UUID id) {
        transporterRepository.deleteById(id);
    }
}
