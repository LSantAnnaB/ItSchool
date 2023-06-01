package com.it.school.DTO.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CourseInsertDTO {

    private String nameCourse;
    private String workload;
    private String teacherName;

}
