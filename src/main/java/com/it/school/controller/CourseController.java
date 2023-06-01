package com.it.school.controller;

import com.it.school.DTO.course.CourseDTO;
import com.it.school.DTO.course.CourseInsertDTO;
import com.it.school.DTO.teacher.TeacherDTO;
import com.it.school.service.CourseService;
import com.it.school.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;


    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<CourseDTO> courseDTO = courseService.findAll();
        return ResponseEntity.ok(courseDTO);
    }

    @GetMapping("/page")
    public ResponseEntity<List<CourseDTO>> getAllByPage(Pageable pageable) {
        List<CourseDTO> courseDTO = courseService.findAllByPage(pageable);
        return ResponseEntity.ok(courseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.findById(id);
        return ResponseEntity.ok(courseDTO);

    }

    @GetMapping("/nameCourse/{nameCourse}")
    public ResponseEntity<CourseDTO> getByName(@PathVariable String nameCourse ){
        CourseDTO courseDTO = courseService.findByName(nameCourse);
        return ResponseEntity.ok(courseDTO);
    }

    @PostMapping("/insert")
    public ResponseEntity<CourseDTO> post(@Valid @RequestBody CourseInsertDTO courseInsertDTO) {
        TeacherDTO teacher = teacherService.findByName(courseInsertDTO.getTeacherName());
        CourseDTO courseDTO = courseService.insert(courseInsertDTO,teacher);
        return ResponseEntity.ok(courseDTO);
    }
//
//    @PutMapping
//    public ResponseEntity<Course> put(@Valid @RequestBody Course course) {
//        return courseService.findById(course.getId())
//                .map(response -> ResponseEntity.status(HttpStatus.OK)
//                        .body(courseService.save(course)))
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        Optional<Course> course = courseService.findById(id);
//        if (course.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        courseService.deleteById(id);
//    }
}
