package com.it.school.DTO.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInsertDTO {

    private String teacherName;
    private String cpf;
    private String email;
    private String cep;
}
