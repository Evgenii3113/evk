package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String deleteStd(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "Student removed";
    }
    @GetMapping("/allstd/{id}")
    public List<Student> findByCourse(@PathVariable Integer id){
        return studentService.findByCourse(id);

    }
}
