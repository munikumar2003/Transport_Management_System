package com.example.tms.dto;

import com.example.tms.entity.Truck;

import java.util.List;

public record TransporterDto(String companyName, double rating, List<Truck> availableTrucks) {
}
