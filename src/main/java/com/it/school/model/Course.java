package com.it.school.model;

import com.it.school.DTO.course.CourseInsertDTO;
import com.it.school.DTO.teacher.TeacherDomain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Name COURSE is required")
    @Size(min = 1, max = 100)
    private String nameCourse;

    @NotNull(message = " WORKLOAD is required")
    @Size(min = 1, max = 3)
    private String workload;

    private TeacherDomain teacherDomain;

    public Course(CourseInsertDTO courseInsertDTO) {

        this.nameCourse = courseInsertDTO.getNameCourse();
        this.workload = courseInsertDTO.getWorkload();
    }

}
