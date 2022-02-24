package com.CodeClanLab.example.courseBookingLab.controllers;

import com.CodeClanLab.example.courseBookingLab.models.Customer;
import com.CodeClanLab.example.courseBookingLab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(
            @RequestParam(name="course", required = false) String course,
            @RequestParam(name="town", required = false) String town,
            @RequestParam(name="courseName", required = false) String  courseName) {
        if (course != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }
        if (town != null &&  courseName != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
