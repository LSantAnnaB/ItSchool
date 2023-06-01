package com.it.school.model;

import com.it.school.DTO.course.CourseDomain;
import com.it.school.DTO.student.StudentInsertDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Student NAME is required")
    @Size(min = 10, max = 100)
    private String name;

    // @CPF

    @NotBlank(message = "Student CPF is required")
    private String cpf;

    @Size(min = 10, max = 1000)
    @NotBlank(message = "Student E-MAIL is required")
    private String email;

    private Adress adress;
    private CourseDomain course;

    public Student(StudentInsertDTO studentInsertDTO) {
        this.name = studentInsertDTO.getName();
        this.cpf = studentInsertDTO.getCpf();
        this.email = studentInsertDTO.getEmail();


    }
}
