package com.example.tms.service;

import com.example.tms.dto.BidDto;
import com.example.tms.entity.Bid;
import com.example.tms.entity.Load;
import com.example.tms.entity.Transporter;
import com.example.tms.repository.BidRepository;
import com.example.tms.repository.LoadRepository;
import com.example.tms.repository.TransporterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BidService {

    private final BidRepository bidRepository;
    private final LoadRepository loadRepository;
    private final TransporterRepository transporterRepository;

    public BidService(BidRepository bidRepository, LoadRepository loadRepository, TransporterRepository transporterRepository) {
        this.bidRepository = bidRepository;
        this.loadRepository = loadRepository;
        this.transporterRepository = transporterRepository;
    }

    public Bid createBid(UUID loadId, UUID transporterId, BidDto bidDto) {
        Load load = loadRepository.findById(loadId).orElseThrow(() -> new RuntimeException("Load not found"));
        Transporter transporter = transporterRepository.findById(transporterId).orElseThrow(() -> new RuntimeException("Transporter not found"));

        // Multiple bids validation rule
        if (bidRepository.findAll().stream().anyMatch(b -> b.getLoad().getLoadId().equals(loadId) && b.getTransporter().getTransporterId().equals(transporterId))) {
            throw new RuntimeException("A transporter cannot bid more than once for the same load");
        }

        // Rating validation rule
        if (transporter.getRating() < 4.5) {
            throw new RuntimeException("A transporter's rating must be at least 4.5 to bid for a load");
        }

        Bid bid = new Bid();
        bid.setLoad(load);
        bid.setTransporter(transporter);
        bid.setProposedRate(bidDto.proposedRate());
        bid.setStatus(bidDto.status());
        return bidRepository.save(bid);
    }

    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid getBidById(UUID id) {
        return bidRepository.findById(id).orElse(null);
    }
}
