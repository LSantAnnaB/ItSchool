package com.it.school.controller;

import com.it.school.DTO.adress.AdressDTO;
import com.it.school.DTO.teacher.TeacherDTO;
import com.it.school.DTO.teacher.TeacherInsertDTO;
import com.it.school.service.AdressService;
import com.it.school.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdressService adressService;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAll() {
        List<TeacherDTO> teacherDTOList = teacherService.findAll();
        return ResponseEntity.ok(teacherDTOList);
    }

    @GetMapping("/page")
    public ResponseEntity<List<TeacherDTO>> getAllByPage(Pageable pageable) {
        List<TeacherDTO> teacherDTOList = teacherService.findAllByPage(pageable);
        return ResponseEntity.ok(teacherDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
       TeacherDTO teacherDTO = teacherService.findById(id);
       return ResponseEntity.ok(teacherDTO);
    }


    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<TeacherDTO> getByCpf(@PathVariable String cpf ){
        TeacherDTO teacherDTO = teacherService.findByCpf(cpf);
        return ResponseEntity.ok(teacherDTO);
    }

    @GetMapping("/teacherName/{teacherName}")
    public ResponseEntity<TeacherDTO> getByName(@PathVariable String teacherName ){
        TeacherDTO teacherDTO = teacherService.findByName(teacherName);
        return ResponseEntity.ok(teacherDTO);
    }


    @PostMapping
    public ResponseEntity<TeacherDTO> post(@Valid @RequestBody TeacherInsertDTO teacherInsertDTO){
      AdressDTO adressDTO = adressService.adressQuery(teacherInsertDTO.getCep());
      TeacherDTO insert = teacherService.insert(teacherInsertDTO,adressDTO);
      return ResponseEntity.ok(insert);
    }
//
//    @PutMapping
//    public ResponseEntity<Teacher> put(@Valid @RequestBody Teacher teacher){
//        return teacherService.findById(teacher.getId())
//                .map(response -> ResponseEntity.status(HttpStatus.OK)
//                        .body(teacherService.save(teacher)))
//                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id){
//        Optional<Teacher> teacher = teacherService.findById(id);
//        if (teacher.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        teacherService.deleteById(id);
//    }
}
