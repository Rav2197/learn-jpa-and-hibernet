package com.in28min.springboot.learnjpaandhibernet.course.JPA;


import com.in28min.springboot.learnjpaandhibernet.courseRepo.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    //@Autowired
    @PersistenceContext  // most Specific Import
    EntityManager entityManager;

    // Inserting a Row
    public void insert(Course course) {
        entityManager.merge(course);
    }

    // Finding by Id

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    // Delete by Id

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}
