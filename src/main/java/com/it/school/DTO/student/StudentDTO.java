package com.it.school.DTO.student;

import com.it.school.DTO.adress.AdressDTO;
import com.it.school.DTO.course.CourseDTO;
import com.it.school.model.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {


    private String name;
    private String cpf;
    private String email;
    private CourseDTO courseDTO;
    private AdressDTO adressDTO;


    public StudentDTO(Student student) {
        name = student.getName();
        cpf = student.getCpf();
        email = student.getEmail();
        adressDTO = new AdressDTO(student.getAdress());
        courseDTO = new CourseDTO(student.getCourse());

    }



}

