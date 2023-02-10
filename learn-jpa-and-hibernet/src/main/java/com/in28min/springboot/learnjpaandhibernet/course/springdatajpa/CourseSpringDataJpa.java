package com.in28min.springboot.learnjpaandhibernet.course.springdatajpa;

import com.in28min.springboot.learnjpaandhibernet.courseRepo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpa extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);


}
