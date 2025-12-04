package com.example.tms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Transporter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transporterId;

    private String companyName;
    private double rating;

    @ElementCollection
    private List<Truck> availableTrucks;
}
