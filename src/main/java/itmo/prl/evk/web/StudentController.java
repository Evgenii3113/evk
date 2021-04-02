package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/new")
    public StudentEntity saveStd(@RequestBody Student student) {

        return studentService.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> findAllStd() {
        return studentService.findAll();
    }


    @GetMapping("/find/")
    public Optional<StudentEntity> readStd(@PathVariable Integer id) {
        return studentService.findById(id);
    }



    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteStd(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student removed", HttpStatus.OK);
    }
}

