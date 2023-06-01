package com.it.school.DTO.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CourseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nameCourse;
    private String workload;
    private String teacherName;

    public CourseDomain(CourseDTO courseDTO) {
        this.nameCourse = courseDTO.getNameCourse();
        this.workload = courseDTO.getWorkload();
    }
}
