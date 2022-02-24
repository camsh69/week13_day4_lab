package com.CodeClanLab.example.courseBookingLab;

import com.CodeClanLab.example.courseBookingLab.models.Booking;
import com.CodeClanLab.example.courseBookingLab.models.Course;
import com.CodeClanLab.example.courseBookingLab.models.Customer;
import com.CodeClanLab.example.courseBookingLab.repositories.BookingRepository;
import com.CodeClanLab.example.courseBookingLab.repositories.CourseRepository;
import com.CodeClanLab.example.courseBookingLab.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingLabApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateBooking() {
		Customer customer = new Customer("Joe Bloggs", "Edinburgh", 24);
		customerRepository.save(customer);
		Course course = new Course("Java", "Edinburgh", 5);
		courseRepository.save(course);
		Booking booking = new Booking("24 February 2022", customer, course);
		bookingRepository.save(booking);

	}

	@Test
	public void canFindCourseByRating() {
		List<Course> found = courseRepository.findByRating(4);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindAllCustomersForCourse() {
		List<Customer> found = customerRepository.findByBookingsCourseName("Java");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindAllCoursesForCustomers() {
		List<Course> found = courseRepository.findByBookingsCustomerName("Joe Bloggs");
		assertEquals(2, found.size());
	}

	@Test
	public void canFindAllBookingsByDate() {
		List<Booking> found = bookingRepository.findByDate("24 February 2022");
		assertEquals(5, found.size());
	}

	@Test
	public void canFindCustomerInATownForGivenCourse() {
		List<Customer> found = customerRepository.findByTownIgnoreCaseAndBookingsCourseName("Edinburgh" , "Java");
		assertEquals("Joe Bloggs", found.get(0).getName());
	}

	@Test
	public void canFindCustomerInATownForGivenCourseOverCertainAge() {
		List<Customer> found = customerRepository
				.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseName(20,"glasgow" , "JavaScript");
		assertEquals("Jane Bloggs", found.get(0).getName());
	}

}
