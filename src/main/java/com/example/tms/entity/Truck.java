package com.example.tms.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Table(name = "truck")
public class Truck {

    private String truckType;
    private int count;
}
