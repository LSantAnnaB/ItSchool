package com.it.school.controller;

import com.it.school.DTO.adress.AdressDTO;
import com.it.school.DTO.course.CourseDTO;
import com.it.school.DTO.student.StudentDTO;
import com.it.school.DTO.student.StudentInsertDTO;
import com.it.school.service.AdressService;
import com.it.school.service.CourseService;
import com.it.school.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private AdressService adressService;
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {

        List<StudentDTO> studentDTOList = studentService.findAll();
        return ResponseEntity.ok(studentDTOList);
    }

    @GetMapping("/page")
    public ResponseEntity<List<StudentDTO>> getAllByPage(Pageable pageable) {

        List<StudentDTO> studentDTOList = studentService.findAllByPage(pageable);
        return ResponseEntity.ok(studentDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.findById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<StudentDTO> getByCpf(@PathVariable String cpf) {
        StudentDTO studentDTO = studentService.findByCpf(cpf);
        return ResponseEntity.ok(studentDTO);

    }

    @GetMapping("/nameStudent/{nameStudent}")
    public ResponseEntity<StudentDTO> getByName(@PathVariable String nameStudent) {
        StudentDTO studentDTO = studentService.findByName(nameStudent);
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping("/insert")
    public ResponseEntity<StudentDTO> post(@RequestBody @Valid StudentInsertDTO studentInsertDTO) {
        AdressDTO adress = adressService.adressQuery(studentInsertDTO.getCep());
        CourseDTO courseDTO = courseService.findByName(studentInsertDTO.getNameCourse());
        StudentDTO insert = studentService.insert(studentInsertDTO, adress,courseDTO);
        return ResponseEntity.ok(insert);

    }

//    @PutMapping
//    public ResponseEntity<Student> put(@Valid @RequestBody StudentInsertDTO studentInsertDTO, Long id) {
//        StudentDTO studentDTO = studentService.findById(id)
//                .map(response -> ResponseEntity.status(HttpStatus.OK)
//
//                        .body(studentService.save(student)))
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        StudentDTO student = studentService.findById(id);
        studentService.deleteById(id);
    }

}
