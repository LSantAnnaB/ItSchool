package com.it.school.repository;


import com.it.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    public Optional<Teacher> findTeacherByTeacherNameContainingIgnoreCase(@Param("teacherName") String teacherName);
    public Optional<Teacher> findTeacherByCpf(@Param("cpf") String cpf);
}
