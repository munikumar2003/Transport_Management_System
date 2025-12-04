package com.example.tms.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Truck {

    private String truckType;
    private int count;
}
