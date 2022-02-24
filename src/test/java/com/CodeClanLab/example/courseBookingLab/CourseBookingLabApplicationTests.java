package com.CodeClanLab.example.courseBookingLab;

import com.CodeClanLab.example.courseBookingLab.models.Booking;
import com.CodeClanLab.example.courseBookingLab.repositories.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseBookingLabApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canCreateBooking() {
//		Booking booking = new Booking("24 February 2022");
//	}

}
