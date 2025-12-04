package com.example.tms.service;

import com.example.tms.dto.ShipperDto;
import com.example.tms.entity.Shipper;
import com.example.tms.repository.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShipperService {

    private final ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    public Shipper createShipper(ShipperDto shipperDto) {
        Shipper shipper = new Shipper();
        shipper.setCompanyName(shipperDto.companyName());
        shipper.setRating(shipperDto.rating());
        return shipperRepository.save(shipper);
    }

    public List<Shipper> getAllShippers() {
        return shipperRepository.findAll();
    }

    public Shipper getShipperById(UUID id) {
        return shipperRepository.findById(id).orElse(null);
    }

    public Shipper updateShipper(UUID id, ShipperDto shipperDto) {
        Shipper existingShipper = shipperRepository.findById(id).orElse(null);
        if (existingShipper != null) {
            existingShipper.setCompanyName(shipperDto.companyName());
            existingShipper.setRating(shipperDto.rating());
            return shipperRepository.save(existingShipper);
        }
        return null;
    }

    public void deleteShipper(UUID id) {
        shipperRepository.deleteById(id);
    }
}
