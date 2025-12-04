package com.example.tms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "load")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID loadId;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;
    private String loadingCity;
    private String unloadingCity;
    private Timestamp loadingDate;
    private String productType;
    private double weight;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private String truckType;
    private int noOfTrucks;

    @Enumerated(EnumType.STRING)
    private LoadStatus status;

    private Timestamp datePosted;

    @Version
    private Long version;
}
