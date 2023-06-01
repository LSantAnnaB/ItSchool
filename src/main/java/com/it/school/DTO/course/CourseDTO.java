package com.it.school.DTO.course;

import com.it.school.DTO.teacher.TeacherDTO;
import com.it.school.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseDTO {

    private String nameCourse;
    private String workload;
    private TeacherDTO teacherDTO;

    public CourseDTO(Course course){
        nameCourse = course.getNameCourse();
        workload = course.getWorkload();
        teacherDTO = new TeacherDTO(course.getTeacherDomain());

    }

    public CourseDTO(CourseDomain course){
        nameCourse = course.getNameCourse();
        workload = course.getWorkload();

    }

}
