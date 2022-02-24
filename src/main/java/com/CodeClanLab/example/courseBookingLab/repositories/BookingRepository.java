package com.CodeClanLab.example.courseBookingLab.repositories;

import com.CodeClanLab.example.courseBookingLab.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
