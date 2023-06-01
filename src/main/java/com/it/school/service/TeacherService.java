package com.it.school.service;

import com.it.school.DTO.adress.AdressDTO;
import com.it.school.DTO.teacher.TeacherDTO;
import com.it.school.DTO.teacher.TeacherInsertDTO;
import com.it.school.model.Adress;
import com.it.school.model.Teacher;
import com.it.school.repository.TeacherRepository;
import com.it.school.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherDTO> findAll() {
        List<Teacher> teachersList = teacherRepository.findAll();
        return teachersList.stream()
                .map(x -> new TeacherDTO(x)).collect(Collectors.toList());
    }

    public List<TeacherDTO> findAllByPage(Pageable pageable) {
        Page<Teacher> teachersList = teacherRepository.findAll(pageable);
        return teachersList.stream()
                .map(x -> new TeacherDTO(x)).collect(Collectors.toList());
    }


    public TeacherDTO findById(Long id) {
        return teacherRepository.findById(id).map(TeacherDTO::new).
                orElseThrow(()-> new NotFoundException("Id not found "+ id));

    }

    public TeacherDTO findByCpf(String cpf) {
       return teacherRepository.findTeacherByCpf(cpf).map(TeacherDTO::new).
                orElseThrow(() -> new NotFoundException("CPF not found " + cpf));

    }

    public TeacherDTO findByName(String teacherName) {

        return teacherRepository
                .findTeacherByTeacherNameContainingIgnoreCase(teacherName).map(TeacherDTO::new).
                orElseThrow(() -> new NotFoundException("teacher Name not found " + teacherName));

    }

    public TeacherDTO insert(TeacherInsertDTO teacherInsertDTO, AdressDTO adressDTO) {

        Teacher entity = new Teacher(teacherInsertDTO);
        Adress adress = new Adress(adressDTO);
        entity.setAdress(adress);
        Teacher persistedEntity = teacherRepository.save(entity);

        return new TeacherDTO(persistedEntity);
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }
}
