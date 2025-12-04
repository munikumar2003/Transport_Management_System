package com.example.tms.controller;

import com.example.tms.entity.Booking;
import com.example.tms.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestParam UUID loadId) {
        return bookingService.createBooking(loadId);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id);
    }
}
