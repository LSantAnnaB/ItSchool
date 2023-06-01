package com.it.school.model;

import com.it.school.DTO.teacher.TeacherInsertDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_teacher")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Teacher teacher Name is required")
    @Size(min = 10, max = 100)
    private String teacherName;


    @Size(min = 11, max = 11)
    @NotBlank(message = "Teacher CPF is required")
    private String cpf;

    @Size(min = 10, max = 1000)
    @NotBlank(message = "Teacher E-MAIL is required")
    private String email;

    private Adress adress;

    public Teacher(TeacherInsertDTO teacherInsertDTO) {
        this.teacherName = teacherInsertDTO.getTeacherName();
        this.cpf = teacherInsertDTO.getCpf();
        this.email = teacherInsertDTO.getEmail();

    }
}
