package com.it.school.service;

import com.it.school.DTO.adress.AdressDTO;
import com.it.school.DTO.course.CourseDTO;
import com.it.school.DTO.course.CourseDomain;
import com.it.school.DTO.student.StudentDTO;
import com.it.school.DTO.student.StudentInsertDTO;
import com.it.school.model.Adress;
import com.it.school.model.Student;
import com.it.school.repository.StudentRepository;
import com.it.school.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentDTO> findAll() {

        List<Student> studentsList = studentRepository.findAll();
        return studentsList.stream()
                .map(StudentDTO::new).collect(Collectors.toList());

    }


    public List<StudentDTO> findAllByPage(Pageable pageable) {

        Page<Student> studentsList = studentRepository.findAll(pageable);
        return studentsList.stream()
                .map(StudentDTO::new).collect(Collectors.toList());

    }


    public StudentDTO findById(Long id) {

            return studentRepository.findById(id).map(StudentDTO::new).orElseThrow(
                    () -> new NotFoundException("Id not found " + id ));

    }
    public StudentDTO findByCpf(String cpf) {

       return studentRepository.findStudentByCpf(cpf).map(StudentDTO::new).
               orElseThrow(()-> new NotFoundException("CPF not found " + cpf));



    }
    public StudentDTO findByName(String name) {
        return studentRepository.findStudentByNameContainingIgnoreCase(name).map(StudentDTO::new).
                orElseThrow(()-> new NotFoundException("Name not found " + name));
    }

    public StudentDTO insert(StudentInsertDTO studentInsertDTO, AdressDTO adressDTO, CourseDTO courseDTO) {

        Student entity = new Student(studentInsertDTO);
        Adress adress = new Adress(adressDTO);
        CourseDomain courseDomain = new CourseDomain(courseDTO);
        entity.setAdress(adress);
        entity.setCourse(courseDomain);
       Student persistedEntity = studentRepository.save(entity);

        return new StudentDTO(persistedEntity);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


}

