package com.it.school.DTO.teacher;

import com.it.school.DTO.adress.AdressDTO;
import com.it.school.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TeacherDTO {

    private String teacherName;
    private String cpf;
    private String email;
    private AdressDTO adressDTO;

    public TeacherDTO(Teacher teacher) {
        this.teacherName = teacher.getTeacherName();
        this.cpf = teacher.getCpf();
        this.email = teacher.getEmail();
        this.adressDTO = new AdressDTO(teacher.getAdress());

    }

    public TeacherDTO(TeacherDomain teacherDomain) {
        this.teacherName = teacherDomain.getTeacherName();


    }
}
