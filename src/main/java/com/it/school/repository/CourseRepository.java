package com.it.school.repository;

import com.it.school.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository <Course,Long>{

    public Optional<Course> findCourseByNameCourseContainingIgnoreCase(@Param("nameCourse") String nameCourse);

}
