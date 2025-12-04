package com.example.tms.dto;

import com.example.tms.entity.BookingStatus;

import java.sql.Timestamp;

public record BookingDto(int allocatedTrucks, double finalRate, BookingStatus status, Timestamp bookedAt) {
}
