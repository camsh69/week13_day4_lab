package com.CodeClanLab.example.courseBookingLab.repositories;

import com.CodeClanLab.example.courseBookingLab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
