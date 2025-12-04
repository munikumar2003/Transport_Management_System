package com.example.tms.controller;

import com.example.tms.dto.TransporterDto;
import com.example.tms.entity.Transporter;
import com.example.tms.service.TransporterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transporters")
public class TransporterController {

    private final TransporterService transporterService;

    public TransporterController(TransporterService transporterService) {
        this.transporterService = transporterService;
    }

    @PostMapping
    public Transporter createTransporter(@RequestBody TransporterDto transporterDto) {
        return transporterService.createTransporter(transporterDto);
    }

    @GetMapping
    public List<Transporter> getAllTransporters() {
        return transporterService.getAllTransporters();
    }

    @GetMapping("/{id}")
    public Transporter getTransporterById(@PathVariable UUID id) {
        return transporterService.getTransporterById(id);
    }

    @PutMapping("/{id}")
    public Transporter updateTransporter(@PathVariable UUID id, @RequestBody TransporterDto transporterDto) {
        return transporterService.updateTransporter(id, transporterDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTransporter(@PathVariable UUID id) {
        transporterService.deleteTransporter(id);
    }
}
