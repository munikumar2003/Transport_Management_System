package com.example.tms.dto;

import com.example.tms.entity.BidStatus;

import java.sql.Timestamp;

public record BidDto(double proposedRate, int trucksOffered, BidStatus status, Timestamp submittedAt) {
}
