package com.example.moviebooking.service;

import com.example.moviebooking.dto.BookingRequest;
import com.example.moviebooking.dto.BookingResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    public BookingResponse bookTickets(BookingRequest request) {
        // Simulate a booking operation
        BookingResponse response = new BookingResponse();
        response.setBookingId(UUID.randomUUID().toString());
        response.setStatus("CONFIRMED");
        response.setMessage("Booking successful for seats: " + request.getSeatNumbers());
        return response;
    }
}
