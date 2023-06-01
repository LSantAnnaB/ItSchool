package com.it.school.repository;


import com.it.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public Optional<Student> findStudentByNameContainingIgnoreCase(@Param("nameStudent") String nameStudent);
    public Optional<Student> findStudentByCpf(@Param("cpf") String cpf);


}
