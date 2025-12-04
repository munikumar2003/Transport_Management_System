package com.example.tms.service;

import com.example.tms.entity.Bid;
import com.example.tms.entity.Booking;
import com.example.tms.entity.BookingStatus;
import com.example.tms.entity.Load;
import com.example.tms.repository.BidRepository;
import com.example.tms.repository.BookingRepository;
import com.example.tms.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final LoadRepository loadRepository;
    private final BidRepository bidRepository;

    public BookingService(BookingRepository bookingRepository, LoadRepository loadRepository, BidRepository bidRepository) {
        this.bookingRepository = bookingRepository;
        this.loadRepository = loadRepository;
        this.bidRepository = bidRepository;
    }

    public Booking createBooking(UUID loadId) {
        Load load = loadRepository.findById(loadId).orElseThrow(() -> new RuntimeException("Load not found"));

        // Auto-assignment of loads rule
        List<Bid> bids = bidRepository.findAll().stream().filter(b -> b.getLoad().getLoadId().equals(loadId)).collect(Collectors.toList());
        bids.sort(Comparator.comparing(Bid::getProposedRate).thenComparing(b -> b.getTransporter().getRating(), Comparator.reverseOrder()));

        Bid bestBid = bids.get(0);

        Booking booking = new Booking();
        booking.setLoad(load);
        booking.setTransporter(bestBid.getTransporter());
        booking.setFinalRate(bestBid.getProposedRate());
        booking.setStatus(BookingStatus.CONFIRMED);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(UUID id) {
        return bookingRepository.findById(id).orElse(null);
    }
}
