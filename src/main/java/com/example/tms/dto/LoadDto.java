package com.example.tms.dto;

import com.example.tms.entity.LoadStatus;
import com.example.tms.entity.WeightUnit;

import java.sql.Timestamp;

public record LoadDto(String shipperId, String loadingCity, String unloadingCity, Timestamp loadingDate, String productType, double weight, WeightUnit weightUnit, String truckType, int noOfTrucks, LoadStatus status, Timestamp datePosted) {
}
