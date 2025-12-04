package com.example.tms.controller;

import com.example.tms.dto.ShipperDto;
import com.example.tms.entity.Shipper;
import com.example.tms.service.ShipperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shippers")
public class ShipperController {

    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @PostMapping
    public Shipper createShipper(@RequestBody ShipperDto shipperDto) {
        return shipperService.createShipper(shipperDto);
    }

    @GetMapping
    public List<Shipper> getAllShippers() {
        return shipperService.getAllShippers();
    }

    @GetMapping("/{id}")
    public Shipper getShipperById(@PathVariable UUID id) {
        return shipperService.getShipperById(id);
    }

    @PutMapping("/{id}")
    public Shipper updateShipper(@PathVariable UUID id, @RequestBody ShipperDto shipperDto) {
        return shipperService.updateShipper(id, shipperDto);
    }

    @DeleteMapping("/{id}")
    public void deleteShipper(@PathVariable UUID id) {
        shipperService.deleteShipper(id);
    }
}
