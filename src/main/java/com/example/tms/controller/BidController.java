package com.example.tms.controller;

import com.example.tms.dto.BidDto;
import com.example.tms.entity.Bid;
import com.example.tms.service.BidService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bids")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping
    public Bid createBid(@RequestParam UUID loadId, @RequestParam UUID transporterId, @RequestBody BidDto bidDto) {
        return bidService.createBid(loadId, transporterId, bidDto);
    }

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @GetMapping("/{id}")
    public Bid getBidById(@PathVariable UUID id) {
        return bidService.getBidById(id);
    }
}
