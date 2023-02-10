package com.in28min.springboot.learnjpaandhibernet.course.jdbc;

import com.in28min.springboot.learnjpaandhibernet.courseRepo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    // the thing that enable us to fire queries

    @Autowired
    private JdbcTemplate springJdbcTemplate;


    private static String INSERT_QUERY =
            """
                insert into course(id,name,author)
                values(?,?,?);
            """;
    private static String Insert_DEL_QUERY =
            """
                delete from course where id = ?
            """;
    // Query for getting details through Id

    private static String SELECT_QUERY =
            """
                select * from course where id = ?
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTemplate.update(Insert_DEL_QUERY,id);

    }

    // Select by Id

    public Course findById(long id){
        return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
