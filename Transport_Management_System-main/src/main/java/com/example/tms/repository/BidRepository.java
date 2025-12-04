package com.example.tms.repository;

import com.example.tms.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BidRepository extends JpaRepository<Bid, UUID> {
}
