package com.CodeClanLab.example.courseBookingLab.repositories;

import com.CodeClanLab.example.courseBookingLab.models.Course;
import com.CodeClanLab.example.courseBookingLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String course);

    List<Customer> findByTownIgnoreCaseAndBookingsCourseName(String town, String courseName);

    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseName(Integer age, String town, String courseName);
}
