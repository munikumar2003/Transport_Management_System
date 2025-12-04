package com.example.tms.service;

import com.example.tms.dto.LoadDto;
import com.example.tms.entity.Load;
import com.example.tms.repository.LoadRepository;
import com.example.tms.repository.ShipperRepository;
import com.example.tms.repository.TransporterRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LoadService {

    private final LoadRepository loadRepository;
    private final TransporterRepository transporterRepository;
    private final ShipperRepository shipperRepository;

    public LoadService(LoadRepository loadRepository, TransporterRepository transporterRepository, ShipperRepository shipperRepository) {
        this.loadRepository = loadRepository;
        this.transporterRepository = transporterRepository;
        this.shipperRepository = shipperRepository;
    }

    public Load createLoad(LoadDto loadDto) {
        // Capacity validation rule
        if (transporterRepository.findAll().stream().noneMatch(t -> t.getAvailableTrucks().stream().anyMatch(truck -> truck.getTruckType().equals(loadDto.truckType()) && truck.getCount() >= loadDto.noOfTrucks()))) {
            throw new RuntimeException("No transporter has enough trucks for this load");
        }

        Load load = new Load();
        load.setShipper(shipperRepository.findById(UUID.fromString(loadDto.shipperId())).orElseThrow(() -> new RuntimeException("Shipper not found")));
        load.setLoadingCity(loadDto.loadingCity());
        load.setUnloadingCity(loadDto.unloadingCity());
        load.setLoadingDate(loadDto.loadingDate());
        load.setProductType(loadDto.productType());
        load.setWeight(loadDto.weight());
        load.setWeightUnit(loadDto.weightUnit());
        load.setTruckType(loadDto.truckType());
        load.setNoOfTrucks(loadDto.noOfTrucks());
        load.setStatus(loadDto.status());
        load.setDatePosted(loadDto.datePosted());
        return loadRepository.save(load);
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Load getLoadById(UUID id) {
        return loadRepository.findById(id).orElse(null);
    }

    public Load updateLoad(UUID id, LoadDto loadDto) {
        Load existingLoad = loadRepository.findById(id).orElse(null);
        if (existingLoad != null) {
            existingLoad.setShipper(shipperRepository.findById(UUID.fromString(loadDto.shipperId())).orElseThrow(() -> new RuntimeException("Shipper not found")));
            existingLoad.setLoadingCity(loadDto.loadingCity());
            existingLoad.setUnloadingCity(loadDto.unloadingCity());
            existingLoad.setLoadingDate(loadDto.loadingDate());
            existingLoad.setProductType(loadDto.productType());
            existingLoad.setWeight(loadDto.weight());
            existingLoad.setWeightUnit(loadDto.weightUnit());
            existingLoad.setTruckType(loadDto.truckType());
            existingLoad.setNoOfTrucks(loadDto.noOfTrucks());
            existingLoad.setStatus(loadDto.status());
            existingLoad.setDatePosted(loadDto.datePosted());
            return loadRepository.save(existingLoad);
        }
        return null;
    }

    public void deleteLoad(UUID id) {
        loadRepository.deleteById(id);
    }
}
