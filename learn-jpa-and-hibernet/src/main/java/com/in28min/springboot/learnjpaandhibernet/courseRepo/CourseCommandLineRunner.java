package com.in28min.springboot.learnjpaandhibernet.courseRepo;

import com.in28min.springboot.learnjpaandhibernet.course.JPA.CourseJpaRepository;
import com.in28min.springboot.learnjpaandhibernet.course.jdbc.CourseJdbcRepository;
import com.in28min.springboot.learnjpaandhibernet.course.springdatajpa.CourseSpringDataJpa;
import com.in28min.springboot.learnjpaandhibernet.courseRepo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//
//    @Autowired
//    private CourseJdbcRepository repository;
//
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpa repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn Azure JPA", "in28mins"));
        repository.save(new Course(2,"Learn AWS JPA", "in28mins"));
        repository.save(new Course(3,"Learn DevOps JPA", "in28mins"));
        repository.save(new Course(4,"Learn Full Stack JPA", "in28mins"));

        repository.deleteById(4l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));

        System.out.println(repository.count());
        System.out.println(repository.findAll());

        System.out.println(repository.findByAuthor("in28mins"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByName("Learn AWS JPA"));
        System.out.println(repository.findByName(



                ""));
    }
}
