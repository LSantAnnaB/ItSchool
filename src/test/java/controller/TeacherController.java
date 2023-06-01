package controller;

import com.it.school.model.Teacher;
import com.it.school.repository.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teacher")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAll() {
        return ResponseEntity.ok(teacherRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        return teacherRepository.findById(id)
                .map(response -> ResponseEntity.ok(response))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Teacher> post(@Valid @RequestBody Teacher teacher){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(teacherRepository.save(teacher));
    }

    @PutMapping
    public ResponseEntity<Teacher> put(@Valid @RequestBody Teacher teacher){
        return teacherRepository.findById(teacher.getId())
                .map(response -> ResponseEntity.status(HttpStatus.OK)
                        .body(teacherRepository.save(teacher)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        teacherRepository.deleteById(id);
    }
}
