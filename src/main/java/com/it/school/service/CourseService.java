package com.it.school.service;


import com.it.school.DTO.course.CourseDTO;
import com.it.school.DTO.course.CourseInsertDTO;
import com.it.school.DTO.teacher.TeacherDTO;
import com.it.school.DTO.teacher.TeacherDomain;
import com.it.school.model.Course;
import com.it.school.repository.CourseRepository;
import com.it.school.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;


    public List<CourseDTO> findAll() {
        List<Course> courseList =  courseRepository.findAll();
        return courseList.stream()
                .map(x-> new CourseDTO(x)).collect(Collectors.toList());

    }

    public List<CourseDTO> findAllByPage(Pageable pageable) {
        Page<Course> courseList =  courseRepository.findAll(pageable);
        return courseList.stream()
                .map(x-> new CourseDTO(x)).collect(Collectors.toList());

    }
    public CourseDTO findById(Long id) {
        Course entity = courseRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Id not found " + id));
        CourseDTO courseDTO = new CourseDTO(entity);
        return courseDTO;
    }

    public CourseDTO findByName(String nameCourse) {
      return courseRepository.findCourseByNameCourseContainingIgnoreCase(nameCourse).
              map(CourseDTO::new).orElseThrow(() -> new NotFoundException("Course not found " + nameCourse));
    }

    public CourseDTO insert(CourseInsertDTO courseInsertDTO, TeacherDTO teacherDTO) {
        Course entity = new Course(courseInsertDTO);
        TeacherDomain teacherDomain = new TeacherDomain(teacherDTO);
        entity.setTeacherDomain(teacherDomain);
        Course persistedEntity = courseRepository.save(entity);

        return new CourseDTO(persistedEntity);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
