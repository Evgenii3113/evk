package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

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

    @GetMapping("/find")
    public Student readStd(@RequestParam String surname) {
        return studentService.findBySurname(surname);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteStd(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allstd")
    public List<Student> findByCourse(@RequestParam Integer id) {
        return studentService.findByCourse(id);

    }


}

