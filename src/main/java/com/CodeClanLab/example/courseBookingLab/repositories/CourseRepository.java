package com.CodeClanLab.example.courseBookingLab.repositories;

import com.CodeClanLab.example.courseBookingLab.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
