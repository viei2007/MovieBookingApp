package com.example.moviebooking.controller;

import com.example.moviebooking.dto.BookingRequest;
import com.example.moviebooking.dto.BookingResponse;
import com.example.moviebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> bookTickets(@RequestBody BookingRequest request) {
        BookingResponse response = bookingService.bookTickets(request);
        return ResponseEntity.ok(response);
    }
}
