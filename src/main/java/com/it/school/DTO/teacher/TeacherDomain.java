package com.it.school.DTO.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String teacherName;

    public TeacherDomain(TeacherDTO teacherDTO) {
        this.teacherName = teacherDTO.getTeacherName();
    }
}
