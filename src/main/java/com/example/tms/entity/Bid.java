package com.example.tms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID bidId;

    @ManyToOne
    @JoinColumn(name = "loadId")
    private Load load;

    @ManyToOne
    @JoinColumn(name = "transporterId")
    private Transporter transporter;

    private double proposedRate;

    @Enumerated(EnumType.STRING)
    private BidStatus status;

    private Timestamp submittedAt;
}
