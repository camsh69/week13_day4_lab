package com.CodeClanLab.example.courseBookingLab.controllers;

import com.CodeClanLab.example.courseBookingLab.models.Booking;
import com.CodeClanLab.example.courseBookingLab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBooking(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
