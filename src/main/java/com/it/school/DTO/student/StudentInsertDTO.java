package com.it.school.DTO.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentInsertDTO {


    private String name;
    private String cpf;
    private String email;
    private String cep;
    private String nameCourse;


}
