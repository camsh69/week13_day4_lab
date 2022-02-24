package com.CodeClanLab.example.courseBookingLab.components;

import com.CodeClanLab.example.courseBookingLab.models.Booking;
import com.CodeClanLab.example.courseBookingLab.models.Course;
import com.CodeClanLab.example.courseBookingLab.models.Customer;
import com.CodeClanLab.example.courseBookingLab.repositories.BookingRepository;
import com.CodeClanLab.example.courseBookingLab.repositories.CourseRepository;
import com.CodeClanLab.example.courseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Customer customer1 = new Customer("Joe Bloggs", "Edinburgh", 24);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jane Bloggs", "Glasgow", 21);
        customerRepository.save(customer2);



        Course course1 = new Course("Java", "Edinburgh", 5);
        courseRepository.save(course1);

        Course course2 = new Course("JavaScript", "Edinburgh", 4);
        courseRepository.save(course2);

        Course course3 = new Course("Python", "Edinburgh", 4);
        courseRepository.save(course3);


        Booking booking1 = new Booking("24 February 2022", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("24 February 2022", customer2, course1);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("24 February 2022", customer2, course2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("24 February 2022", customer2, course3);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("24 February 2022", customer1, course3);
        bookingRepository.save(booking5);
    }
}
